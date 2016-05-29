package com.zakolenko.epam.patterns.state.example.activecontext;

public class Main {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Station station = new RadioFM();
        radio.setStation(station);
        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}
