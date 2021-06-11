package org.example.model.action;

import org.example.model.item.Item;
import org.example.model.user.User;

import java.time.Instant;

public class Reservation extends Action {

    private Long positionInQueue;

    public Reservation(Instant time, User user, Item item, Long positionInQueue) {
        super(time, user, item, ActionType.RESERVATION);
        this.positionInQueue = positionInQueue;
    }

    public Long getPositionInQueue() {
        return positionInQueue;
    }

    public void setPositionInQueue(Long positionInQueue) {
        this.positionInQueue = positionInQueue;
    }
}
