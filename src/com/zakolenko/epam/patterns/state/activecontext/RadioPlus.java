package com.zakolenko.epam.patterns.state.activecontext;

public class RadioPlus implements Station {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
