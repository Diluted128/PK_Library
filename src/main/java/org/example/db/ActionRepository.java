package org.example.db;

import org.example.model.action.Action;
import org.example.model.item.Item;
import org.example.model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActionRepository {

    private static final File actionsFile = new File("./src/main/java/org/example/db/actions.bin");
    private static ActionRepository actionRepository = createSingletonInstance();

    private static ActionRepository createSingletonInstance() {
        try {
            return new ActionRepository();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ActionRepository getActionRepository() {
        return actionRepository;
    }

    public ArrayList<Action> getAllActions() {
        ArrayList<Action> actions = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(actionsFile))) {
            actions = (ArrayList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actions;
    }

    public boolean addNewActionAndReturnIfSuccessful(Action newAction) {

        ArrayList<Action> actions = getAllActions();
        actions.add(newAction);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(actionsFile))) {
            outputStream.writeObject(actions);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeActionAndReturnIfSuccessful(Action action) {

        ArrayList<Action> actions = getAllActions();
        actions.remove(action);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(actionsFile))) {
            outputStream.writeObject(actions);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public void saveActionsToFile(List<Action> actions) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(actionsFile))) {
            outputStream.writeObject(actions);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void saveActionToFile(Action action) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(actionsFile))) {
            outputStream.writeObject(action);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

