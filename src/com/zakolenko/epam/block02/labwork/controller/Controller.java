package com.zakolenko.epam.block02.labwork.controller;

import com.zakolenko.epam.block02.labwork.view.View;
import com.zakolenko.epam.block02.labwork.model.Model;

import java.util.Scanner;

/**
 * An instance of this class is used to process user actions and data validation.
 *
 * @author Roman Zakolenko
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * This method processes the data entered by the user,
     * calculates the area of a rhombus through logic models
     * and presents results to the user through a view.
     */
    public void processUser() {
        this.view.printMessage(View.CALCULATE_SQUARE_RHOMBUS);
        try (Scanner scanner = new Scanner(System.in)) {
            int side = 0;
            while (side <= 0) {
                this.view.printMessage(View.INPUT_INT_SIDE);
                side = inputIntValueWithScanner(scanner);
                if (side <= 0) {
                    this.view.printMessage(View.WRONG_INPUT_INT_DATA, View.SIDE_MUST_BE_POSITIVE);
                }
            }
            int angle = 0;
            while (angle <= Model.MIN_ANGLE || angle >= Model.MAX_ANGLE) {
                this.view.printMessage(View.INPUT_INT_ANGLE);
                angle = inputIntValueWithScanner(scanner);
                if (angle <= Model.MIN_ANGLE || angle >= Model.MAX_ANGLE) {
                    this.view.printMessage(View.WRONG_INPUT_INT_DATA, View.ANGLE_MUST_BE_IN_RANGE);
                }
            }
            view.printMessage(View.SQUARE_RHOMBUS + model.getSquareOfRhomb(side, angle));
        }
    }

    /**
     * Introduces an integer from the console.
     * If you enter it incorrectly informs the user about this through view.
     *
     * @param sc used to enter from the console
     * @return integer entered from the console
     */
    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
}
