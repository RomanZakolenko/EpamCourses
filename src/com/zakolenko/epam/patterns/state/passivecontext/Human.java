package com.zakolenko.epam.patterns.state.passivecontext;

public class Human {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void doSomething() {
        this.activity.doSomething(this);
    }
}
