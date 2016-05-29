package com.zakolenko.epam.patterns.state.labwork;

public class Human {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void action() {
        state.action();
    }

    public void seeBeast() {
        state = new Hunter();
    }

    public void goToRiver() {
        state = new Fisherman();
    }

    public void goMeadowMushroom() {
        state = new Mushroomer();
    }
}
