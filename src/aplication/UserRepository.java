package aplication;

import domain.User;

public interface UserRepository {
    void saveUser(User user);
    User getUserByName(String name);
}