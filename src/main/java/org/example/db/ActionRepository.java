package org.example.db;

import org.example.model.action.Action;
import org.example.model.action.Rental;
import org.example.model.action.Reservation;
import org.example.model.action.Return;
import org.example.model.item.Article;
import org.example.model.item.Book;
import org.example.model.item.Item;
import org.example.model.item.Newspaper;
import org.example.model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        //TODO: change to xml encoder/decoder
        ArrayList<Action> actions = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(actionsFile))) {
            actions = (ArrayList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actions;
    }

    public boolean saveActionsToFile(List<Action> actions) {
        //TODO: change to xml encoder/decoder
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(actionsFile))) {
            outputStream.writeObject(actions);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }




    public boolean addNewActionAndReturnIfSuccessful(Action newAction) {
        ArrayList<Action> actions = getAllActions();
        actions.add(newAction);
        return saveActionsToFile(actions);
    }

    public boolean removeActionAndReturnIfSuccessful(Action action) {
        ArrayList<Action> actions = getAllActions();
        actions.remove(action);
        return saveActionsToFile(actions);
    }

    public List<Action> removeActionById(List<Action> actions, Action action) {
        return actions.stream().filter(a -> a.getActionID() != action.getActionID()).collect(Collectors.toList());
    }


    public boolean updateActionInfo(Action updatedAction) {
        List<Action> actions = getAllActions();

        Action actionToBeUpdated;
        Optional<Action> optionalAction = actions.stream().filter(a -> a.getActionID() == updatedAction.getActionID()).findFirst();
        if (optionalAction.isEmpty()) {
            return false;
        }
        actionToBeUpdated = optionalAction.get();


        actions = removeActionById(actions, actionToBeUpdated);

        actionToBeUpdated.setActionType(updatedAction.getActionType());
        actionToBeUpdated.setItem(updatedAction.getItem());
        actionToBeUpdated.setTime(updatedAction.getTime());
        actionToBeUpdated.setUser(updatedAction.getUser());


        if (actionToBeUpdated instanceof Rental) {
            ((Rental) actionToBeUpdated).setActive(((Rental) actionToBeUpdated).isActive());
            ((Rental) actionToBeUpdated).setDaysDuration(((Rental) actionToBeUpdated).getDaysDuration());
        }
        if (actionToBeUpdated instanceof Reservation) {
            ((Reservation) actionToBeUpdated).setPositionInQueue(((Reservation) actionToBeUpdated).getPositionInQueue());
        }
        if (actionToBeUpdated instanceof Return) {
            ((Return) actionToBeUpdated).setInTime(((Return) actionToBeUpdated).isInTime());
            ((Return) actionToBeUpdated).setPenalty(((Return) actionToBeUpdated).getPenalty());
        }

        actions.add(actionToBeUpdated);
        return true;
    }


}

