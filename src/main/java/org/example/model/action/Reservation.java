package org.example.model.action;

import org.example.model.item.Item;
import org.example.model.user.User;

import java.time.Instant;

public class Reservation extends Action {

    private int positionInQueue;

    public Reservation(Instant time, User user, Item item, int positionInQueue) {
        super(time, user, item, ActionType.RESERVATION);
        this.positionInQueue = positionInQueue;
    }

    public int getPositionInQueue() {
        return positionInQueue;
    }

    public void setPositionInQueue(int positionInQueue) {
        this.positionInQueue = positionInQueue;
    }
}
