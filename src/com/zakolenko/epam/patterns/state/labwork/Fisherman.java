package com.zakolenko.epam.patterns.state.labwork;

public class Fisherman implements State {

    @Override
    public void action() {
        System.out.println("Catch fish!");
    }
}
