package com.reimbursement.connection;

import com.reimbursement.webmodels.ReimbursementRequest;
import com.reimbursement.webmodels.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;

import org.apache.log4j.Logger;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.persistence.*;

public class SQLConnect<Bean>{

    private static Logger LOGGER = Logger.getLogger(SQLConnect.class);
    private SessionFactory sessionFactory;

    private final Class<Bean> beanClass;
    private String tableName;
    private String primaryKey;
    private final int isolationLevel;

    private Session session;
    private Transaction transaction;
    private boolean autoCommit;

    public SQLConnect(Class<Bean> type, boolean autoCommit, int isolationLevel){

        this.autoCommit = autoCommit;
        this.beanClass = type;

        this.setTable();
        this.setPrimaryKey();

        this.isolationLevel = isolationLevel;

        this.configure();

        this.logIsolationLevel();
    }

    /**
     * @param type - Class obj for the bean
     */
    public SQLConnect(Class<Bean> type){
        this(type, true);
    }

    /**
     * @param type - Class obj for the bean
     * @param autoCommit - true: commits DML queries automatically.
     */
    public SQLConnect(Class<Bean> type, boolean autoCommit){
        this(type, autoCommit, Connection.TRANSACTION_READ_COMMITTED);
    }

    private void configure(){

        Configuration config = new Configuration().configure();


        if(config != null){
            // Add dependency beans to config

            config.addAnnotatedClass(ReimbursementRequest.class);
            config.addAnnotatedClass(User.class);

            // Set Properties
            Properties properties = config.getProperties();

            // Set Isolation Level
            properties.setProperty("hibernate.connection.isolation", String.valueOf(isolationLevel));


            // Set up session factory
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder()
                            .applySettings(properties);
            this.sessionFactory = config.buildSessionFactory(builder.build());

        }
    }

    /**
     * @param index index of object in database
     * @return returns unique instance from database
     */
    public Bean getByPrimaryKey(Object index){

        this.beginTransaction();

        Bean bean = (Bean) this.session.get(beanClass, (Serializable) index);

        this.closeSession();

        return bean;
    }


    /**
     * @param  col column of parameter to search for
     * @param index value to search for
     * @return returns unique object from database
     */
    public Bean getByNaturalKey(String col, Object index){

        beginTransaction();

        Bean bean = this.session.byNaturalId(beanClass)
                        .using(col, index)
                        .load();

        this.closeSession();

        return bean;
    }

    /**
     * @param col column of parameter to search for
     * @param value value to search for
     * @return returns unique object from database
     */
    public Bean getUnique(String col, Object value){
        return this.getUnique(new String[]{col}, new Object[]{value});
    }

    /**
     * @param cols List of parameter columns
     * @param values List of parameter values
     * @return Returns unique item from database
     */
    public Bean getUnique(String[] cols, Object[] values){

        if(cols.length!=values.length)
            throw new RuntimeException("number of columns ("+cols.length+") does not match number of values ("+values.length+")");

        this.beginTransaction();

        Query q = this.createQueryFromParams(cols, values);

        Bean bean = (Bean) q.uniqueResult();

        this.closeSession();

        return bean;
    }

    public List<Bean> get(String col, Object[] values) {

        this.beginTransaction();

        String[] cols = new String[values.length];
        for(int i = 0; i<values.length; i++){
            cols[i] = col;
        }

        Query q = createQueryFromParams(cols, values, false);


        List<Bean> b = q.getResultList();

        if (autoCommit) {
            this.commitTransaction();
        }

        return b;
    }

    /**
     * @param cols List of parameter columns
     * @param values List of parameter values
     * @return Returns list of items matching parameters
     */
    public List<Bean> get(String[] cols, Object[] values){

        if(cols.length!=values.length)
            throw new RuntimeException("number of columns ("+cols.length+") does not match number of values ("+values.length+")");

        this.beginTransaction();

        Query q = createQueryFromParams(cols, values);

        List<Bean> b = q.getResultList();

        if (autoCommit) {
            this.commitTransaction();
        }

        return b;
    }

    /**
     * @param  col column of parameter to search for
     * @param value value to search for
     * @return Returns list of items matching parameters
     */
    public List<Bean> get(String col, Object value){
        return get(new String[]{col}, new Object[]{value});
    }

    /**
     * @param obj POJO To be inserted
     */
    public Serializable insert(Bean obj){
        beginTransaction();

        Serializable id = this.session.save(obj);
        this.session.flush();

        if (autoCommit) {
            this.commitTransaction();
        }

        return id;

    }

    /**
     * @param obj POJO To be deleted
     */
    public void delete(Bean obj){
        beginTransaction();

        this.session.delete(obj);
        this.session.flush();

        if(autoCommit)
            this.commitTransaction();

    }

    public void update(Bean obj){
        beginTransaction();

        session.update(obj);
        session.flush();

        if(autoCommit)
            this.commitTransaction();

    }

    /**
     * Opens a session and begins a transaction
     */
    public void beginTransaction(){
        if(this.session ==null)
            this.session = this.sessionFactory.openSession();
        if(this.transaction ==null)
            this.transaction = this.session.beginTransaction();
        else
            throw new RuntimeException("Transaction currently in progress - commit or rollback to start a new one");
    }

    /**
     * Closes the current session
     */
    public void closeSession(){
        if(session !=null)
            this.session.close();
        if(transaction !=null)
            try {
                this.transaction.rollback();
            }catch(IllegalStateException ignore){}

        this.session = null;
        this.transaction = null;
    }

    /**
     * Commits the current transaction and frees up space for a new one
     */
    public void commitTransaction(){
        this.transaction.commit();
        this.transaction = null;
    }

    /**
     * Rolls back the current transaction and frees up space for a new one
     */
    public void rollbackTransaction(){
        this.transaction.rollback();
        this.transaction = null;
    }

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    private void logIsolationLevel(){
        Session session = this.sessionFactory.openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                LOGGER.debug("Transaction isolation level is "+ String.valueOf(connection.getTransactionIsolation()));
            }
        });
    }

    private void setTable() {
        Table table = this.beanClass.getAnnotation(Table.class);
        this.tableName = table.name();
    }

    private void setPrimaryKey() {
        boolean set = false;
        for (Field field : this.beanClass.getDeclaredFields()) {
            Id id = field.getAnnotation(Id.class);
            if(id!=null){
                this.primaryKey = field.getAnnotation(Column.class).name();
                set = true;
            }
        }
        if(!set) this.primaryKey = null;
    }

    private List<Class> searchAnnotations(Class... keys){
        List<Class> annotations = new ArrayList<>();
        for (Field field : this.beanClass.getDeclaredFields()) {
            for(Class key : keys){
                annotations.addAll(Arrays.asList(field.getAnnotationsByType(key)));
            }
        }
        return annotations;

    }

    private Serializable getPrimaryKey(Bean bean) {
        for (Field field : this.beanClass.getDeclaredFields()) {
            Id id = field.getAnnotation(Id.class);
            if(id!=null){
                field.setAccessible(true);
                try {
                    return (Serializable) field.get(bean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Query createQueryFromParams(String[] cols, Object[] values){
        return createQueryFromParams(cols, values, true);
    }

    private Query createQueryFromParams(String[] cols, Object[] values, boolean anding){

        String query = "FROM "+beanClass.getName();

        int i = 0;
        for(String col : cols){
            if((anding && (cols[i]!=null || values[i]!=null) )||
                    (anding && (cols[i]!=null && values[i]!=null) )
            ) {
                if (i > 0) query += (anding)?" AND ":" OR ";
                else query += " WHERE ";
                query += col + " = :" + col;
                i++;
            }
        }


        Query q = session.createQuery(query);

        i = 0;
        for(Object value : values){
            if((anding && (cols[i]!=null || values[i]!=null) )||
                    (anding && (cols[i]!=null && values[i]!=null) )
              ){
                q.setParameter(cols[i], value);
                i++;
            }
        }
        System.out.println();

        return q;
    }


}
