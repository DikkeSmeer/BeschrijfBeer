import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {
    @Test
    void registratieControle() {
        UserAuth userAuth = new UserAuth();
        // Case - 0 0 0
        System.out.println("Test: 0 0 0");
        assertFalse(userAuth.register("Youri Knoop1", "testing123", "testing", "22153551@student.hhs.nlfrfgrg"));
        // Case - 1 0 0
        System.out.println("Test: 1 0 0");
        assertFalse(userAuth.register("Youri Knoop1", "esting123", "esting123", "22153551.student.hhs.nl"));
        // Case - 1 1 0
        System.out.println("Test: 1 1 0");
        assertFalse(userAuth.register("Youri Knoop1", "!Testing123", "!Testing123", "student.hhs.nl"));
        // Case - 1 0 1
        System.out.println("Test: 1 0 1");
        assertFalse(userAuth.register("Youri Knoop1", "esting123", "esting123", "22153551@student.hhs.nl"));
        // Case - 1 1 1
        System.out.println("Test: 1 1 1");
        assertTrue(userAuth.register("Youri Knoop1", "!Testing123", "!Testing123", "22153551@student.hhs.nl"));
    }

}





//        // All conditions Are in order
//        System.out.println("Test 1: 1 1 1");
//        assertTrue(userAuth.register("Youri Knoop1", "!Testing123", "!Testing123", "22153551@student.hhs.nl"));
//        // Condition A – password are not the same
//        System.out.println("Test 2: 0 1 1");
//        assertFalse(userAuth.register("Youri Knoop2", "!Testing123", "!Testing12", "testing@gmail.com"));
//        // Condition B – Password does not match the pattern of isValidPassword()
//        System.out.println("Test 3: 1 0 1");
//        assertFalse(userAuth.register("Youri Knoop3", "Testing123", "Testing123", "testing@gmail.com"));
//        // Condition C – The email does not match the pattern of isValidEmail()
//        System.out.println("Test 4: 1 1 0");
//        assertFalse(userAuth.register("Youri Knoop4", "!Testing123", "!Testing123", "testing@gmail.testingg"));
//        // Case B+C False
//        System.out.println("Test 5: 1 0 0");
//        assertFalse(userAuth.register("Youri Knoop4", "testing123", "testing123", "testing@gmail.testingg"));