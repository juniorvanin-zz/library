package library;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private Gson gson = new Gson();

    private HttpClient httpClient;


    public UserService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public User[] getUsersFromJson() throws InterruptedException, IOException, URISyntaxException {

        String response = httpClient.get("https://jsonplaceholder.typicode.com/users");

        return gson.fromJson(response, User[].class);
    }

    public List<User> searchByName(String name) throws InterruptedException, IOException, URISyntaxException {

        User[] users = getUsersFromJson();

        return Arrays.asList(users).stream()
                .filter(user -> user.getName().contains(name))
                .collect(Collectors.toList());
    }

    public List<User> searchById(int id) throws InterruptedException, IOException, URISyntaxException {

        User[] users = getUsersFromJson();

        return Arrays.asList(users).stream()
                .filter(user -> {
                    return user.getId() == id ? true : false;
                })
                .collect(Collectors.toList());
    }

    public List<User> searchByUsername(String username) throws InterruptedException, IOException, URISyntaxException {

        User[] users = getUsersFromJson();

        return Arrays.asList(users).stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList());
    }


    // delete

    // update
}
