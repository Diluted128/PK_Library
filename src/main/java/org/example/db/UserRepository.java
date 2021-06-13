package org.example.db;

import org.example.model.action.Action;
import org.example.model.user.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public boolean saveUsersToFile(List<User> users) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(usersFile))) {
            outputStream.writeObject(users);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public boolean addNewUserAndReturnIfSuccessful(User newUser) {
        ArrayList<User> users = getAllUsers();

        if (users.stream().anyMatch(u -> u.getLogin().equals(newUser.getLogin()))) {
            return false;
        }

        users.add(newUser);
        return saveUsersToFile(users);

    }

    public boolean removeUserAndReturnIfSuccessful(User user) {
        ArrayList<User> users = getAllUsers();
        users.remove(user);
        return saveUsersToFile(users);
    }

    public List<User> removeUserById(List<User> users, User user) {
        return users.stream().filter(u -> u.getUserID() != user.getUserID()).collect(Collectors.toList());
    }

    public boolean updateUserInfo(User updatedUser) {
        List<User> users = getAllUsers();

        User userToBeUpdated;
        Optional<User> optionalUser = users.stream().filter(u -> u.getUserID() == updatedUser.getUserID()).findFirst();
        if (optionalUser.isEmpty()) {
            return false;
        }
        userToBeUpdated = optionalUser.get();


        users = removeUserById(users, userToBeUpdated);

        userToBeUpdated.setLogin(updatedUser.getLogin());
        userToBeUpdated.setPassword(updatedUser.getPassword());
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setPermissions(updatedUser.getPermissions());
        userToBeUpdated.setRoles(updatedUser.getRoles());

        if (updatedUser instanceof Customer) {
            ((Customer) userToBeUpdated).setOnBlacklist(((Customer) updatedUser).isOnBlacklist());
            ((Customer) userToBeUpdated).setPenalty(((Customer) updatedUser).getPenalty());
            ((Customer) userToBeUpdated).setRentedItems(((Customer) updatedUser).getRentedItems());
        }
        if (updatedUser instanceof Manager) {
            ((Manager) userToBeUpdated).setSubordinates(((Manager) updatedUser).getSubordinates());
        }
        users.add(userToBeUpdated);
        return true;
    }

    public ArrayList<User> returnAllWorkers(){
        ArrayList<User> users = getAllUsers();
        ArrayList<User> workers =  new ArrayList<>();
        for(User user : users){
            if(user instanceof Worker)
                workers.add(user);
        }
        return workers;
    }
    public String ReturnPasswordIfEmailSuccessful(String email){
        ArrayList<User> users = getAllUsers();
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user.getPassword();
            }
        }
        return null;
    }
}
