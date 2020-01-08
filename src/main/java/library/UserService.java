package library;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private Gson gson = new Gson();

    private HttpClient httpClient;

    public UserService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<User> searchByName(String name) throws Exception {
        String response = httpClient.get("https://jsonplaceholder.typicode.com/users");

        User[] users = gson.fromJson(response, User[].class);

        return Arrays.asList(users).stream()
                .filter(user -> user.getName().contains(name))
                .collect(Collectors.toList());
    }


    // delete

    // update
}
