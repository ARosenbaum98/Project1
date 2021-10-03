package com.reimbursement.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SQLConnect {

    private SessionFactory sessionFactory;

    public static void configure(){
        Configuration config = new Configuration().configure();

        if(config != null){
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties());
        }
    }


}
