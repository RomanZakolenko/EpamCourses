package com.zakolenko.epam.project1.controller;

import com.zakolenko.epam.project1.model.entities.company.Operator;
import com.zakolenko.epam.project1.view.ViewMessages;
import com.zakolenko.epam.project1.model.Model;
import com.zakolenko.epam.project1.view.View;

import java.util.Scanner;

public class UserController {
    private Model model;
    private View view;

    public UserController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void printOperatorsInfo() {
        view.printMessage(ViewMessages.COMPANY_CLIENTS_NUMBER, Operator.KYIVSTAR.toString());
        view.printMessage(String.valueOf(model.getNumberOfClients(Operator.KYIVSTAR)));
        view.printMessage(ViewMessages.COMPANY_CLIENTS_NUMBER, Operator.MTS.toString());
        view.printMessage(String.valueOf(model.getNumberOfClients(Operator.MTS)));
        view.printMessage(ViewMessages.SORTED_TARIFFS, Operator.KYIVSTAR.toString());
        view.printMessage(String.valueOf(model.sortTariffsByMonthlyPrice(Operator.KYIVSTAR)));
        view.printMessage(ViewMessages.SORTED_TARIFFS, Operator.MTS.toString());
        view.printMessage(String.valueOf(model.sortTariffsByMonthlyPrice(Operator.MTS)));
    }

    public void findTariffByMonthlyPrice() {
        view.printMessage(ViewMessages.SEARCH_TARIFF);
        view.printMessage(ViewMessages.CHOOSE_COMPANY);
        int index = 0;
        double min = 0;
        double max = 0;
        try (Scanner sc = new Scanner(System.in)) {
            while (!checkCompanyIndex(index = inputIntWithScanner(sc))) {
                view.printMessage(ViewMessages.WRONG_INPUT);
                view.printMessage(ViewMessages.CHOOSE_COMPANY);
            }
            view.printMessage(ViewMessages.INPUT_RANGE, ViewMessages.MONTHLY_PRICE);
            while (!checkPriceRange(min = inputDoubleWithScanner(sc), max = inputDoubleWithScanner(sc))) {
                view.printMessage(ViewMessages.WRONG_INPUT);
                view.printMessage(ViewMessages.INPUT_RANGE, ViewMessages.MONTHLY_PRICE);
            }
        }
        view.printMessage(ViewMessages.SUITABLE_TARIFFS);
        view.printMessage(model.getTariffsByMontlyPrice(Operator.values()[index - 1], min, max).toString());
    }

    public int inputIntWithScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }

    public double inputDoubleWithScanner(Scanner sc) {
        while (!sc.hasNextDouble()) {
            sc.next();
        }
        return sc.nextDouble();
    }

    private boolean checkCompanyIndex(int index) {
        return (index - 1) >= 0 && (index - 1) < Operator.values().length;
    }

    private boolean checkPriceRange(double min, double max) {
        return (max >= min) && min >= 0;
    }
}
