package com.zakolenko.epam.block01.randnumber;

import java.util.Scanner;

/**
 * An instance of this class is used to process user actions.
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
     * Simulates the process of the game by guessing a random number.
     */
    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setRandNumber(model.rand());
        int userAnswer = 0;
        boolean checkRange;
        do {
            checkRange = false;
            while (!checkRange) {
                userAnswer = inputIntValueWithScanner(scanner);
                checkRange = checkRange(userAnswer);
                if (!checkRange) {
                    view.printMessage(view.ANSWER_INT + userAnswer);
                    view.printMessage(view.WRONG_DIAPASON);
                }
                model.addToNumberOfAttempts(1);
            }
        } while (!model.compareWithRandNumber(userAnswer));
        view.printMessage(view.USER_WIN);
        view.printMessage(view.NUMBER_OF_ATTEMPTS + model.getNumberOfAttempts());
    }

    /**
     * Introduces an integer from the console.
     * If you enter it incorrectly informs the user about this through view.
     *
     * @param sc used to enter from the console
     * @return integer entered from the console
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(view.CURRENT_DIAPASON + model.getCurrentRandMin() + ".." + model.getCurrentRandMax());
        view.printMessage(view.INPUT_INT_DATA);
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    public boolean checkRange(int answer) {
        return answer > model.getCurrentRandMin() && answer < model.getCurrentRandMax();
    }
}
