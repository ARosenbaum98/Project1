import static org.junit.Assert.*;

import com.reimbursement.webmodels.*;
import org.junit.*;

import java.time.LocalDateTime;

public class TestModels {

    @Test
    public void testJUnit(){
        assertTrue(true);
    }

    @Test
    public void testUser() {
        User user = new User(1, false, "email@email.com", "TestUser","testU$er123",
                             LocalDateTime.of(2021, 11, 27, 2, 26, 50),
                             "mr", "FirstName", "MiddleName","LastName","",
                              "m", "imageid.png", "1800 Address Street", "", "Jackson", "AL", 123234);

        assertNotSame("", user.toString());
        assertEquals(user, user.clone());

    }

    @Test
    public void testReimbursementRequest(){
        ReimbursementRequest rr = new ReimbursementRequest(1, 1, true, false, 1000, "I wanted it",
                                                           LocalDateTime.of(2021, 5, 15, 0, 0),
                                                           LocalDateTime.of(2021, 6, 1, 0, 0),
                                                           null, -1);

        assertNotSame("", rr.toString());
        assertEquals(rr, rr.clone());
    }
}
