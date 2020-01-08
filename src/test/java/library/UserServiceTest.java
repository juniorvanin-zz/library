package library;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UserServiceTest {

    HttpClient mockHttpClient = mock(HttpClient.class);
    UserService userService = new UserService(mockHttpClient);


    @Test
    public void returnUserByName() throws Exception {
        // given
        when(mockHttpClient.get("https://jsonplaceholder.typicode.com/users")).thenReturn(
                "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Leanne Graham\",\n" +
                "    \"username\": \"Bret\",\n" +
                "    \"email\": \"Sincere@april.biz\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Kulas Light\",\n" +
                "      \"suite\": \"Apt. 556\",\n" +
                "      \"city\": \"Gwenborough\",\n" +
                "      \"zipcode\": \"92998-3874\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-37.3159\",\n" +
                "        \"lng\": \"81.1496\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"phone\": \"1-770-736-8031 x56442\",\n" +
                "    \"website\": \"hildegard.org\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Romaguera-Crona\",\n" +
                "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "      \"bs\": \"harness real-time e-markets\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Ervin Howell\",\n" +
                "    \"username\": \"Antonette\",\n" +
                "    \"email\": \"Shanna@melissa.tv\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Victor Plains\",\n" +
                "      \"suite\": \"Suite 879\",\n" +
                "      \"city\": \"Wisokyburgh\",\n" +
                "      \"zipcode\": \"90566-7771\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-43.9509\",\n" +
                "        \"lng\": \"-34.4618\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"phone\": \"010-692-6593 x09125\",\n" +
                "    \"website\": \"anastasia.net\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Deckow-Crist\",\n" +
                "      \"catchPhrase\": \"Proactive didactic contingency\",\n" +
                "      \"bs\": \"synergize scalable supply-chains\"\n" +
                "    }\n" +
                "  }" +
                "]");

        // when
        List<User> users = userService.searchByName("Leanne");

        // then
        List<User> expectedUsers = Arrays.asList((new User("Leanne Graham", "Bret", "ola.com.br")));
        assertEquals(expectedUsers, users);
    }

    @Test
    public void returnEmptyIfDontFindUser() throws Exception {
        // given
        when(mockHttpClient.get("https://jsonplaceholder.typicode.com/users")).thenReturn(
                "[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Leanne Graham\",\n" +
                        "    \"username\": \"Bret\",\n" +
                        "    \"email\": \"Sincere@april.biz\",\n" +
                        "    \"address\": {\n" +
                        "      \"street\": \"Kulas Light\",\n" +
                        "      \"suite\": \"Apt. 556\",\n" +
                        "      \"city\": \"Gwenborough\",\n" +
                        "      \"zipcode\": \"92998-3874\",\n" +
                        "      \"geo\": {\n" +
                        "        \"lat\": \"-37.3159\",\n" +
                        "        \"lng\": \"81.1496\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"phone\": \"1-770-736-8031 x56442\",\n" +
                        "    \"website\": \"hildegard.org\",\n" +
                        "    \"company\": {\n" +
                        "      \"name\": \"Romaguera-Crona\",\n" +
                        "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                        "      \"bs\": \"harness real-time e-markets\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"Ervin Howell\",\n" +
                        "    \"username\": \"Antonette\",\n" +
                        "    \"email\": \"Shanna@melissa.tv\",\n" +
                        "    \"address\": {\n" +
                        "      \"street\": \"Victor Plains\",\n" +
                        "      \"suite\": \"Suite 879\",\n" +
                        "      \"city\": \"Wisokyburgh\",\n" +
                        "      \"zipcode\": \"90566-7771\",\n" +
                        "      \"geo\": {\n" +
                        "        \"lat\": \"-43.9509\",\n" +
                        "        \"lng\": \"-34.4618\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"phone\": \"010-692-6593 x09125\",\n" +
                        "    \"website\": \"anastasia.net\",\n" +
                        "    \"company\": {\n" +
                        "      \"name\": \"Deckow-Crist\",\n" +
                        "      \"catchPhrase\": \"Proactive didactic contingency\",\n" +
                        "      \"bs\": \"synergize scalable supply-chains\"\n" +
                        "    }\n" +
                        "  }" +
                        "]");

        // when
        List<User> users = userService.searchByName("Junior");

        // then
        List<User> expectedUsers = new ArrayList<>();
        assertEquals(expectedUsers, users);
    }

    @Test (expected = InterruptedException.class)
    public void interruptedExceptionByHttp() throws InterruptedException, IOException, URISyntaxException {
        // given
        when(mockHttpClient.get("https://jsonplaceholder.typicode.com/users")).thenThrow(InterruptedException.class);

        // when
        List<User> users = userService.searchByName("Leanne");

        // then
    }

    @Test (expected = IOException.class)
    public void ioExceptionByHttp() throws InterruptedException, IOException, URISyntaxException {
        // given
        when(mockHttpClient.get("https://jsonplaceholder.typicode.com/users")).thenThrow(IOException.class);

        // when
        List<User> users = userService.searchByName("Leanne");

        // then
    }

    @Test (expected = URISyntaxException.class)
    public void uriExceptionByHttp() throws InterruptedException, IOException, URISyntaxException {
        // given
        when(mockHttpClient.get("https://jsonplaceholder.typicode.com/users")).thenThrow(URISyntaxException.class);

        // when
        List<User> users = userService.searchByName("Leanne");

        // then
    }

    @Test
    public void callUserApi() throws Exception {

        HttpClient mockedHttpClient = mock(HttpClient.class);
        when(mockedHttpClient.get("url")).thenReturn("{}");
        // when
//        List<User> users = mockService.searchByName("Leanne Graham");

        // then
//        verify(mockedHttpClientx)
        List<User> expectedUsers = new ArrayList<>();

    }
}