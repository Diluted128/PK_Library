package org.example.library.action;

import org.example.library.item.Item;
import org.example.library.user.User;

import java.time.Instant;

public class Rental extends Action {

    private int daysDuration;
    private boolean isActive;

    public Rental(Instant time, User user, Item item, int daysDuration, boolean isActive) {
        super(time, user, item, ActionType.RENTAL);
        this.daysDuration = daysDuration;
        this.isActive = isActive;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
