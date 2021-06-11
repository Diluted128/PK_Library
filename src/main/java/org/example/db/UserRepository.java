package org.example.db;

import org.example.model.action.Action;
import org.example.model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final File usersFile = new File("./src/main/java/org/example/db/users.bin");
    private static UserRepository userRepository = createSingletonInstance();

    private static UserRepository createSingletonInstance() {
        try {
            return new UserRepository();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(usersFile))) {
            users = (ArrayList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void saveUsersToFile(List<User> users) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(usersFile))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean addNewUserAndReturnIfSuccessful(User newUser) {
        ArrayList<User> users = getAllUsers();

        if (users.stream().anyMatch(u -> u.getLogin().equals(newUser.getEmail()))) {
            return false;
        }


        users.add(newUser);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(usersFile))) {
            outputStream.writeObject(users);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean removeUserAndReturnIfSuccessful(User user) {
        ArrayList<User> users = getAllUsers();

        if (users.stream().anyMatch(u -> u.getLogin().equals(user.getEmail()))) {
            return false;
        }


        users.remove(user);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(usersFile))) {
            outputStream.writeObject(users);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
