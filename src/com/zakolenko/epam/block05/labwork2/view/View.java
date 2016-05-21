package com.zakolenko.epam.block05.labwork2.view;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String... messages) {
        StringBuilder message = new StringBuilder();
        for (String msg : messages) {
            message.append(msg);
        }
        System.out.println(message);
    }
}
