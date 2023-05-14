import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BeerKindvriendelijkTest {

    Beer beer = new Beer("TestBeertje");

    @Test
    public void testIsKindvriendelijk() {
        assertFalse(beer.isKindvriendelijk(1, false, false, false)); // Case 1
        assertFalse(beer.isKindvriendelijk(1, false, false, true)); // Case 2
        assertFalse(beer.isKindvriendelijk(1, false, true, false)); // Case 3
        assertFalse(beer.isKindvriendelijk(1, false, true, true)); // Case 4
        assertFalse(beer.isKindvriendelijk(1, true, false, false)); // Case 5
        assertFalse(beer.isKindvriendelijk(1, true, false, true)); // Case 6
        assertFalse(beer.isKindvriendelijk(1, true, true, false)); // Case 7
        assertFalse(beer.isKindvriendelijk(1, true, true, true)); // Case 8

        assertFalse(beer.isKindvriendelijk(50, false, false, false)); // Case 17
        assertFalse(beer.isKindvriendelijk(50, false, false, true)); // Case 18
        assertFalse(beer.isKindvriendelijk(50, false, true, false)); // Case 19
        assertFalse(beer.isKindvriendelijk(50, false, true, true)); // Case 20
        assertFalse(beer.isKindvriendelijk(50, true, false, false)); // Case 21
        assertFalse(beer.isKindvriendelijk(50, true, false, true)); // Case 22
        assertFalse(beer.isKindvriendelijk(50, true, true, false)); // Case 23
        assertFalse(beer.isKindvriendelijk(50, true, true, true)); // Case 24

        assertFalse(beer.isKindvriendelijk(10, false, false, false)); // Case 9
        assertFalse(beer.isKindvriendelijk(10, false, true, false)); // Case 11
        assertFalse(beer.isKindvriendelijk(10, false, true, true)); // Case 12
        assertFalse(beer.isKindvriendelijk(10, true, false, false)); // Case 13
        assertFalse(beer.isKindvriendelijk(10, true, false, true)); // Case 14
        assertFalse(beer.isKindvriendelijk(10, true, true, false)); // Case 15
        assertFalse(beer.isKindvriendelijk(10, true, true, true)); // Case 16
        assertTrue(beer.isKindvriendelijk(10, false, false, true)); // Case 10
    }
}