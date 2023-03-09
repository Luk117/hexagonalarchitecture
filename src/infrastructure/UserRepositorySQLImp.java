package infrastructure;

import aplication.port.UserRepository;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositorySQLImp implements UserRepository {
    private Connection conn;

    public UserRepositorySQLImp() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "luk", "12345678");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getInt("age"));
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return users;
    }

    @Override
    public User getUserById(String id) {
        User user = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString("id"), rs.getString("name"), rs.getInt("age"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return user;
    }

    @Override
    public void addUser(User user) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ?, age = ? WHERE id = ?");
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
