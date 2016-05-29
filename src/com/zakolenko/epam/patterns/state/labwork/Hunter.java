package com.zakolenko.epam.patterns.state.labwork;

public class Hunter implements State {

    @Override
    public void action() {
        System.out.println("Hunt!");
    }
}
