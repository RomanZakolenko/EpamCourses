package com.zakolenko.epam.patterns.state.example.passivecontext;

public class WeekEnd implements Activity {
    private int count;

    @Override
    public void doSomething(Human human) {
        if (count < 3) {
            System.out.println("WeekEnd!");
            count++;
        } else {
            human.setActivity(new Work());
        }
    }
}
