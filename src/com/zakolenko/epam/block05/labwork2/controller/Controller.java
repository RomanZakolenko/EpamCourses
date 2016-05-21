package com.zakolenko.epam.block05.labwork2.controller;

import com.zakolenko.epam.block05.labwork2.model.Model;
import com.zakolenko.epam.block05.labwork2.model.entities.AbstractComplexNumber;
import com.zakolenko.epam.block05.labwork2.model.entities.AlgebraicComplexNumber;
import com.zakolenko.epam.block05.labwork2.view.View;
import com.zakolenko.epam.block05.labwork2.view.ViewMessages;

import java.util.Scanner;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void processUser() {
        try (Scanner sc = new Scanner(System.in)) {
            view.printMessage(ViewMessages.COMPLEX_NUMBER_ACTION);
            int actionId = 0;
            do {
                view.printMessage(ViewMessages.SELECT_ACTION);
                actionId = inputIntValueWithScanner(sc);
            } while (actionId <= 0 || actionId > 4);
            AbstractComplexNumber[] complexNumbers = inputTwoComplexNumber(sc);
            AbstractComplexNumber resultOfAction = null;
            switch (actionId) {
                case 1:
                    resultOfAction = model.add(complexNumbers[0], complexNumbers[1]);
                    break;
                case 2:
                    resultOfAction = model.subtract(complexNumbers[0], complexNumbers[1]);
                    break;
                case 3:
                    resultOfAction = model.multiply(complexNumbers[0], complexNumbers[1]);
                    break;
                case 4:
                    resultOfAction = model.divide(complexNumbers[0], complexNumbers[1]);
                    break;
            }
            view.printMessage(ViewMessages.ACTION_RESULT);
            view.printMessage(resultOfAction.toString());
        }
    }

    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextDouble()) {
            view.printMessage(ViewMessages.WRONG_INPUT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    public double inputDoubleValueWithScanner(Scanner sc) {
        while (!sc.hasNextDouble()) {
            view.printMessage(ViewMessages.WRONG_INPUT_DATA);
            sc.next();
        }
        return sc.nextDouble();
    }

    public AbstractComplexNumber[] inputTwoComplexNumber(Scanner sc) {
        double realValue;
        double imaginaryValue;
        view.printMessage(ViewMessages.INPUT_FIRST_COMPLEX_NUMBER);
        view.printMessage(ViewMessages.INPUT_DOUBLE_REAL_VALUE);
        realValue = inputDoubleValueWithScanner(sc);
        view.printMessage(ViewMessages.INPUT_DOUBLE_IMAGINARY_VALUE);
        imaginaryValue = inputDoubleValueWithScanner(sc);
        AbstractComplexNumber fistNumber = new AlgebraicComplexNumber(realValue, imaginaryValue);
        view.printMessage(ViewMessages.INPUT_SECOND_COMPLEX_NUMBER);
        view.printMessage(ViewMessages.INPUT_DOUBLE_REAL_VALUE);
        realValue = inputDoubleValueWithScanner(sc);
        view.printMessage(ViewMessages.INPUT_DOUBLE_IMAGINARY_VALUE);
        imaginaryValue = inputDoubleValueWithScanner(sc);
        AbstractComplexNumber secondNumber = new AlgebraicComplexNumber(realValue, imaginaryValue);
        return new AbstractComplexNumber[]{fistNumber, secondNumber};
    }
}
