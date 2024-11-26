package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
public Optional<User> getUserById(int id){
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
}

    public Optional<User> getUserByEmail(String email){
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public List <User> getAllUsers(){
        return new ArrayList<>(users);
    }

}
