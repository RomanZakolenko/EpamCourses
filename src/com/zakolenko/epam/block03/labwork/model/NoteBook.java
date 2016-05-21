package com.zakolenko.epam.block03.labwork.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is used to represent the notebook.
 * Recordings are stored in the subscribers list.
 *
 * @author Roman Zakolenko
 */
public class NoteBook {

    //Contains a subscribers list of notebook.
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public String toString() {
        return Arrays.toString(subscribers.toArray());
    }
}

