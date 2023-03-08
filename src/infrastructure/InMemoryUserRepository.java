package infrastructure;

import aplication.UserRepository;
import domain.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void saveUser(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User getUserByName(String name) {
        return users.get(name);
    }
}
