import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.*;
import org.hibernate.Transaction;
import org.junit.*;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestModels {

    SQLConnect<User> connectUser;

    @Before
    public void before(){
        connectUser = new SQLConnect<>(User.class);
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

    @Test
    public void testInsertDeleteUser(){

        connectUser = new SQLConnect<>(User.class, true, Connection.TRANSACTION_READ_UNCOMMITTED);

        User user = new User(
                -1,
                false,
                "5414243@gmail.com",
                "4544Sebastian22",
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
        connectUser.insert(user);

        User pull = connectUser.getByNaturalKey("username",user.getUsername());
        assertNotNull(pull);

        User old = pull.clone();
        pull.setFname("test123");

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
}
