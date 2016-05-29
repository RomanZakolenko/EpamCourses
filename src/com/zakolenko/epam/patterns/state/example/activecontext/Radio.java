package com.zakolenko.epam.patterns.state.example.activecontext;

public class Radio {
    private Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    public void nextStation() {
        if (station instanceof RadioFM) {
            setStation(new RadioPlus());
        } else {
            if (station instanceof RadioPlus) {
                setStation(new RadioRock());
            } else {
                setStation(new RadioFM());
            }
        }
    }

    public void play() {
        station.play();
    }
}
