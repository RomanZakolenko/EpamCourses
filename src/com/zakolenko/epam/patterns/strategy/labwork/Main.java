package com.zakolenko.epam.patterns.strategy.labwork;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setActivity(new Fisherman());
        human.work();
        human.setActivity(new Mushroomer());
        human.work();
        human.setActivity(new Hunter());
        human.work();
    }
}
