package aplication.port;

import domain.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    User getUserById(String id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String id);

}
