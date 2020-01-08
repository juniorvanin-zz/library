package library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService(new HttpClient());

    @Test
    public void returnBooksByName() throws Exception {
        // when
        List<User> users = userService.searchByName("Leanne Graham");

        // then
        List<User> expectedUsers = new ArrayList<>();
        assertEquals(expectedUsers, users);
    }

    @Test
    public void callUserApi() throws Exception {

        HttpClient mockedHttpClient = mock(HttpClient.class);
        when(mockedHttpClient.get("url")).thenReturn("{}");
        // when
        List<User> users = userService.searchByName("Leanne Graham");

        // then
        verify(mockedHttpClientx)
        List<User> expectedUsers = new ArrayList<>();

    }
}