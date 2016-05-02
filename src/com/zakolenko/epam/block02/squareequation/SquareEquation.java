package com.zakolenko.epam.block02.squareequation;

public class SquareEquation {
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    public SquareEquation() {
    }

    public SquareEquation(double coefficientA, double coefficientB, double coefficientC) {
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
    }

    public double[] solve() {
        if (coefficientA == 0) {
            throw new IllegalArgumentException("a == 0.");
        }
        double d = coefficientB * coefficientB - 4 * coefficientA * coefficientC;
        if (d < 0) {
            return new double[0];
        }
        if (d == 0) {
            return new double[]{-coefficientB / (2 * coefficientA)};
        }
        double x1 = (-coefficientB - Math.sqrt(d)) / (2 * coefficientA);
        double x2 = (-coefficientB + Math.sqrt(d)) / (2 * coefficientA);
        return new double[]{x1, x2};
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(double coefficientA) {
        this.coefficientA = coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(double coefficientB) {
        this.coefficientB = coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientC(double coefficientC) {
        this.coefficientC = coefficientC;
    }
}
