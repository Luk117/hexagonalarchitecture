package aplication;

import domain.User;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, int age) {
        User user = new User(name, age);
        userRepository.saveUser(user);
    }

    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
