package com.zakolenko.epam.patterns.state.activecontext;

public class RadioRock implements Station {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
