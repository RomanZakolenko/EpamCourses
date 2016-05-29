package com.zakolenko.epam.patterns.state.example.passivecontext;

public class RadioFM implements Station {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
