package com.zakolenko.epam.project1;

import com.zakolenko.epam.project1.controller.InitializationController;
import com.zakolenko.epam.project1.controller.UserController;
import com.zakolenko.epam.project1.model.Model;
import com.zakolenko.epam.project1.view.View;

public class Main {
    public static void main(String[] args) {
        InitializationController initController = new InitializationController();
        initController.initialize();
        UserController userController = new UserController(new Model(), new View());
        userController.printOperatorsInfo();
        userController.findTariffByMonthlyPrice();
    }
}
