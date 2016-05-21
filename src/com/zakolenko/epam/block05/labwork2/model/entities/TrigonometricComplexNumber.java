package com.zakolenko.epam.block05.labwork2.model.entities;

public class TrigonometricComplexNumber extends AbstractComplexNumber implements Cloneable {

    private double module;
    private double argument;
    private String representation;

    public TrigonometricComplexNumber(double module, double argument) {
        this.module = module;
        this.argument = argument;
        this.representation = module + "*(cos(" + argument + ") + i*sin(" + argument + "))";
    }

    @Override
    public double getRealValue() {
        return module * Math.cos(argument);
    }

    @Override
    public double getImaginaryValue() {
        return module * Math.sin(argument);
    }

    @Override
    public double getModule() {
        return module;
    }

    @Override
    public double getArgument() {
        return argument;
    }

    @Override
    public AbstractComplexNumber add(AbstractComplexNumber number) {
        double realValue = module * Math.cos(argument) + number.getModule() * Math.cos(number.getArgument());
        double imaginaryValue = module * Math.sin(argument) + number.getModule() * Math.sin(number.getArgument());
        double module = Math.sqrt(Math.pow(realValue, 2) + Math.pow(imaginaryValue, 2));
        double argument = Math.atan(imaginaryValue / realValue);
        return new TrigonometricComplexNumber(module, argument);
    }

    @Override
    public AbstractComplexNumber subtract(AbstractComplexNumber number) {
        double realValue = module * Math.cos(argument) - number.getModule() * Math.cos(number.getArgument());
        double imaginaryValue = module * Math.sin(argument) - number.getModule() * Math.sin(number.getArgument());
        double module = Math.sqrt(Math.pow(realValue, 2) + Math.pow(imaginaryValue, 2));
        double argument = Math.atan(imaginaryValue / realValue);
        return new TrigonometricComplexNumber(module, argument);
    }

    @Override
    public AbstractComplexNumber multiply(AbstractComplexNumber number) {
        return new TrigonometricComplexNumber(module * number.getModule(), argument + number.getArgument());
    }

    @Override
    public AbstractComplexNumber divide(AbstractComplexNumber number) {
        return new TrigonometricComplexNumber(module / number.getModule(), argument - number.getArgument());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TrigonometricComplexNumber number = (TrigonometricComplexNumber) super.clone();
        number.representation = new String(representation);
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TrigonometricComplexNumber number = (TrigonometricComplexNumber) obj;
        if (Double.compare(number.module, module) != 0) return false;
        return Double.compare(number.argument, argument) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(module);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(argument);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TrigonometricComplexNumber{" + representation + '}';
    }
}
