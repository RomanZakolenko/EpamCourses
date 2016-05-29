package com.zakolenko.epam.patterns.state.labwork;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.goToRiver();
        human.action();
        human.goMeadowMushroom();
        human.action();
        human.seeBeast();
        human.action();
    }
}
