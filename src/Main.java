import aplication.port.UserRepository;
import aplication.UserService;
import domain.User;
import infrastructure.InMemoryUserRepository;

public class Main {
    public static void main(String[] args) {
            UserRepository userRepository = new InMemoryUserRepository();
            UserService userService = new UserService(userRepository);
            userService.createUser("Alice", 25);
            User user = userService.getUserByName("Alice");
            System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
        }
}
