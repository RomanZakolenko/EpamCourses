package com.zakolenko.epam.block05.labwork2;

import com.zakolenko.epam.block05.labwork2.controller.Controller;
import com.zakolenko.epam.block05.labwork2.model.Model;
import com.zakolenko.epam.block05.labwork2.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);
        controller.processUser();
    }
}
