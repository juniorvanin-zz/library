package library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void returnUserAsString() {
        // given
        User user = new User("Junior Vanin", "Place Holder", "junior@blabla.com");

        // when
        String userAsString= user.toString();

        // then
        assertEquals("name: Junior Vanin\nusername: Place Holder", userAsString );
    }
}