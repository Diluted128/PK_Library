package org.example.model.action;

import org.example.model.item.Item;
import org.example.model.user.User;

import java.time.Instant;

public class Return extends Action {

    private boolean inTime;
    private double penalty;

    public Return(Instant time, User user, Item item, boolean inTime, double penalty) {
        super(time, user, item, ActionType.RETURN);
        this.inTime = inTime;
        this.penalty = penalty;
    }

    public boolean isInTime() {
        return inTime;
    }

    public void setInTime(boolean inTime) {
        this.inTime = inTime;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}
