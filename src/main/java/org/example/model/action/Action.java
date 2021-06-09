package org.example.model.action;

import org.example.model.item.Item;
import org.example.model.user.User;

import java.time.Instant;

public abstract class Action {


    private Instant time;
    private User user;
    private Item item;
    private ActionType actionType;

    public Action(Instant time, User user, Item item, ActionType actionType) {
        this.time = time;
        this.user = user;
        this.item = item;
        this.actionType = actionType;
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
}
