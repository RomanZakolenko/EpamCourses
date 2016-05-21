package com.zakolenko.epam.block05.labwork2.model.entities;

public abstract class AbstractComplexNumber {

    public abstract double getRealValue();

    public abstract double getImaginaryValue();

    public abstract double getModule();

    public abstract double getArgument();

    public abstract AbstractComplexNumber add(AbstractComplexNumber number);

    public abstract AbstractComplexNumber subtract(AbstractComplexNumber number);

    public abstract AbstractComplexNumber multiply(AbstractComplexNumber number);

    public abstract AbstractComplexNumber divide(AbstractComplexNumber number);
}
