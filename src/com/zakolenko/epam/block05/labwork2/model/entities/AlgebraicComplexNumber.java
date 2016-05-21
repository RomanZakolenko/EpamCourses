package com.zakolenko.epam.block05.labwork2.model.entities;

public class AlgebraicComplexNumber extends AbstractComplexNumber implements Cloneable {

    private double realValue;
    private double imaginaryValue;
    private String representation;

    public AlgebraicComplexNumber(double realValue, double imaginaryValue) {
        this.realValue = realValue;
        this.imaginaryValue = imaginaryValue;
        this.representation = realValue + " + i*(" + imaginaryValue + ")";
    }

    @Override
    public double getRealValue() {
        return realValue;
    }

    @Override
    public double getImaginaryValue() {
        return imaginaryValue;
    }

    @Override
    public double getModule() {
        return Math.sqrt(Math.pow(realValue, 2) + Math.pow(imaginaryValue, 2));
    }

    @Override
    public double getArgument() {
        return Math.atan(imaginaryValue / realValue);
    }

    @Override
    public AbstractComplexNumber add(AbstractComplexNumber number) {
        return new AlgebraicComplexNumber(realValue + number.getRealValue(), imaginaryValue + number.getImaginaryValue());
    }

    @Override
    public AbstractComplexNumber subtract(AbstractComplexNumber number) {
        return new AlgebraicComplexNumber(realValue - number.getRealValue(), imaginaryValue - number.getImaginaryValue());
    }

    @Override
    public AbstractComplexNumber multiply(AbstractComplexNumber number) {
        double realPart = realValue * number.getRealValue() - imaginaryValue * number.getImaginaryValue();
        double imaginaryPart = imaginaryValue * number.getRealValue() + realValue * number.getImaginaryValue();
        return new AlgebraicComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public AbstractComplexNumber divide(AbstractComplexNumber number) {
        double divider = Math.pow(number.getImaginaryValue(), 2) + Math.pow(number.getRealValue(), 2);
        double realPart = (realValue * number.getRealValue() + imaginaryValue * number.getImaginaryValue()) / divider;
        double imaginaryPart = (imaginaryValue * number.getRealValue() - realValue * number.getImaginaryValue()) / divider;
        return new AlgebraicComplexNumber(realPart, imaginaryPart);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        AlgebraicComplexNumber number = (AlgebraicComplexNumber) super.clone();
        number.representation = new String(representation);
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AlgebraicComplexNumber number = (AlgebraicComplexNumber) obj;
        if (Double.compare(number.realValue, realValue) != 0) return false;
        return Double.compare(number.imaginaryValue, imaginaryValue) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(realValue);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imaginaryValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AlgebraicComplexNumber{" + representation + '}';
    }
}
