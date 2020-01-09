package library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void returnUserAsString() {
        // given
        User user = new User(1, "Junior Vanin", "Place Holder", "junior@blabla.com", "123456789", "www.junior.com.br");

        // when
        String userAsString= user.toString();

        // then
        assertEquals("id: 1\nname: Junior Vanin\nusername: Place Holder", userAsString );
    }
}