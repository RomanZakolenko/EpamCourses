package com.zakolenko.epam.block02.labwork;

import com.zakolenko.epam.block02.labwork.controller.Controller;
import com.zakolenko.epam.block02.labwork.model.Model;
import com.zakolenko.epam.block02.labwork.view.View;

/**
 * This class provides an entry point into the program
 * to find the area of a rhombus.
 *
 * @author Roman Zakolenko
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
