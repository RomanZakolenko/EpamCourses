package com.zakolenko.epam.block05.labwork2.model;

import com.zakolenko.epam.block05.labwork2.model.entities.AbstractComplexNumber;

public class Model {

    public AbstractComplexNumber add(AbstractComplexNumber number1, AbstractComplexNumber number2) {
        return number1.add(number2);
    }

    public AbstractComplexNumber subtract(AbstractComplexNumber number1, AbstractComplexNumber number2) {
        return number1.subtract(number2);
    }

    public AbstractComplexNumber multiply(AbstractComplexNumber number1, AbstractComplexNumber number2) {
        return number1.multiply(number2);
    }

    public AbstractComplexNumber divide(AbstractComplexNumber number1, AbstractComplexNumber number2) {
        return number1.divide(number2);
    }
}
