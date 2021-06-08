package org.example.db;

import org.example.library.user.Customer;
import org.example.library.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

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

    public boolean addNewUserAndReturnIfSuccessful(User newUser) {
        ArrayList<User> users = getAllUsers();

        if (users.stream()
                .anyMatch(u -> u.areCredentialsEqual(newUser.getLogin(), newUser.getPassword()))) {
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


}
