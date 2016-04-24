package com.zakolenko.epam.block01.randnumber;

/**
 * @author Roman Zakolenko
 */
public class Game {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
