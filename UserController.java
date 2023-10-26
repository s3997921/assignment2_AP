package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserController {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return users.stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findFirst();
    }

    public void displayUsers() {
        users.forEach(System.out::println);
    }
}
