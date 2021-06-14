package org.example.model.action;

import org.example.model.item.Item;
import org.example.model.user.User;

import java.io.Serializable;
import java.time.Instant;

public abstract class Action implements Serializable {

    private static int idCounter = 1;
    private int actionID;
    private Instant time;
    private User user;
    private Item item;
    private ActionType actionType;

    public Action(Instant time, User user, Item item, ActionType actionType) {
        this.actionID = idCounter++;
        this.time = time;
        this.user = user;
        this.item = item;
        this.actionType = actionType;
    }

    public static void  setStaticCounterToOne() {
        idCounter = 1;
    }

    public int getActionID() {
        return actionID;
    }

    public void setActionID(int actionID) {
        this.actionID = actionID;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (time != null ? !time.equals(action.time) : action.time != null) return false;
        if (user != null ? !user.equals(action.user) : action.user != null) return false;
        if (item != null ? !item.equals(action.item) : action.item != null) return false;
        return actionType == action.actionType;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (actionType != null ? actionType.hashCode() : 0);
        return result;
    }
}
