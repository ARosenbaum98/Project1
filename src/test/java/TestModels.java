import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.*;
import org.hibernate.Transaction;
import org.junit.*;

import java.io.Serializable;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModels {

    SQLConnect<User> connectUser;
    SQLConnect<ReimbursementRequest> connectRequest;

    @Before
    public void before(){
        connectUser = new SQLConnect<>(User.class);
        connectRequest = new SQLConnect<>(ReimbursementRequest.class);
    }

    @Ignore
    public void testJUnit(){
        assertTrue(true);
    }

    @Ignore
    public void testHibernateGetUser(){

        User me = connectUser.getByPrimaryKey(0);
        assertNotNull(me);

    }

    @Ignore
    public void testHibernateGetUserByUsername(){

        User me = connectUser.getByNaturalKey("username", "arosenbaum");
        assertNotNull(me);
    }

    @Ignore
    public void testHibernateGetUserByUniqueValue(){

        User expect = connectUser.getByNaturalKey("username", "arosenbaum");
        User actual = connectUser.getUnique("email","AsherRosenbaumWork@gmail.com");

        assertEquals(expect, actual);
    }

    @Ignore
    public void getUsernameAndPassword(){
        User expect = connectUser.getByNaturalKey("username", "arosenbaum");
        User actual = connectUser.getUnique(
                new String[]{"username", "password"},
                new Object[]{"arosenbaum","p@ssword"}
        );

        assertEquals(expect, actual);
    }

    @Ignore
    public void getListOfAllUsers(){
        List<User> users = connectUser.get(new String[]{},new Object[]{});

        assertNotNull(users);
    }

    @Ignore
    public void testInsertDeleteUser(){

        connectUser = new SQLConnect<>(User.class, true, Connection.TRANSACTION_READ_UNCOMMITTED);

        String randomUsername = String.valueOf(new Random().nextInt(10000));
        String randomEmail = String.valueOf(new Random().nextInt(10000));

        User user = new User(
                -1,
                false,
                randomEmail,
                randomUsername,
                "password!",
                LocalDateTime.now(),
                "Mr.",
                "Sebastian",
                "",
                "Roseblum",
                "",
                "M",
                null,
                "4582 Jamestown Rd",
                "",
                "Arab",
                "AL",
                32305
        );

        // Test Insert
        connectUser.insert(user);

        // Test query
        User pull = connectUser.getByNaturalKey("username",user.getUsername());
        assertNotNull(pull);

        // Test Update
        User old = pull.clone();
        pull.setFname("123test123");
        connectUser.update(pull);

        // Test Delete
        connectUser.delete(pull);

        assertNull(connectUser.getByNaturalKey("username",user.getUsername()));
    }

    @Ignore
    public void getSupervisees(){
        User me = connectUser.getByPrimaryKey(0);
        assertNotNull(me.getSupervisees());
        assertNotEquals(new ArrayList<>(), me.getSupervisees());
    }

    @Test
    public void testInsertUpdateDeleteRequest(){

        User randomUser = connectUser.getByPrimaryKey(42);

        ReimbursementRequest request =
                new ReimbursementRequest(
                        -1,  false, true, 200.00,
                        "",
                        LocalDateTime.of(2020, 12, 13, 0, 0, 0),
                        LocalDateTime.of(2020, 12, 15, 0, 0, 0),
                        LocalDateTime.of(2020, 12, 15, 0, 0, 0),
                        randomUser
                        );

        // Test Insert
        int id = (Integer) connectRequest.insert(request);

        // Test query
        ReimbursementRequest pull = connectRequest.getByPrimaryKey(id);
        assertNotNull(pull);

        // Test Update
        ReimbursementRequest old = pull.clone();
        pull.setDescription("123test123");
        connectRequest.update(pull);
        assertNotEquals(old, pull);

        // Test Delete
        connectRequest.delete(pull);

        assertNull(connectRequest.getByPrimaryKey(id));
    }
}
