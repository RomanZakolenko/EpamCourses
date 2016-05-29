package com.zakolenko.epam.patterns.strategy.labwork;

public class Human {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void work() {
        activity.work();
    }
}
