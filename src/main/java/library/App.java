package library;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService(new HttpClient());

        List<User> users = userService.searchByName("Kurtis");

        users.stream().forEach(System.out::println);
    }
}