import aplication.port.UserRepository;
import aplication.UserService;
import domain.User;
import infrastructure.UserRepositoryMemoryImp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryMemoryImp();

        // Create a new UserService instance using the UserRepositoryImpl instance
        UserService userService = new UserService(userRepository);

        // Add a new user
        User user1 = new User("1", "Alice", 25);
        userService.addUser(user1);

        // Add another user
        User user2 = new User("2", "Bob", 30);
        userService.addUser(user2);

        // Get all users
        List<User> users = userService.getAllUsers();
        System.out.println("All users: ");
        for (User user : users) {
            System.out.println(user.getName() + " (" + user.getAge() + ")");
        }

        // Update a user
        User userToUpdate = userService.getUserById("1");
        userToUpdate.setName("Alice Smith");
        userService.updateUser(userToUpdate);


        // Get a specific user
        User userById = userService.getUserById("2");
        System.out.println("User by ID:");
        System.out.println(userById.getName() + " (" + userById.getAge() + ")");


        // Delete a user
        userService.deleteUser("1");


        // Get all users again
        List<User> updatedUsers = userService.getAllUsers();
        System.out.println("All users (after deletion):");
        for (User user : updatedUsers) {
            System.out.println(user.getName() + " (" + user.getAge() + ")");
        }
    }
}
