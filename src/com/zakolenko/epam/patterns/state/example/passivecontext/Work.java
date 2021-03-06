package com.zakolenko.epam.patterns.state.example.passivecontext;

public class Work implements Activity {

    @Override
    public void doSomething(Human human) {
        System.out.println("Work!");
        human.setActivity(new WeekEnd());
    }
}
