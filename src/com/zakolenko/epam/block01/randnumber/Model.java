package com.zakolenko.epam.block01.randnumber;

import java.util.Random;

/**
 * This class contains logic for the game by guessing numbers.
 *
 * @author Roman Zakolenko
 */
public class Model {
    public static final int RAND_MAX = 100;
    public static final int RAND_MIN = 0;
    private int currentRandMax;
    private int currentRandMin;
    private int randNumber;
    private int numberOfAttempts;

    /**
     * Generates a random integer that is part of the range that set the parameters.
     *
     * @param min lower end of the range
     * @param max upper limit of the range
     * @return random integer that lies in the specified range
     */
    public int rand(int min, int max) {
        if (max < min || min < 0) {
            throw new IllegalArgumentException("wrong range: min = " + min + " , max = " + max);
        }
        currentRandMin = min;
        currentRandMax = max;
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * Generates a random integer that is part of the range RAND_MIN..RAND_MAX.
     *
     * @return random integer that lies in the specified range
     */
    public int rand() {
        return rand(RAND_MIN, RAND_MAX);
    }

    /**
     * Checks whether the input number and the random are equal.
     *
     * @param number will be compared with random
     * @return true if the number and random are equal, in otherwise false
     */
    public boolean guessNumber(int number) {
        if (randNumber == number) {
            return true;
        } else {
            if (number < randNumber) {
                currentRandMin = number + 1;
            } else {
                currentRandMax = number - 1;
            }
            return false;
        }
    }

    public void addToNumberOfAttempts(int value) {
        this.numberOfAttempts += value;
    }

    public int getRandNumber() {
        return randNumber;
    }

    public int getCurrentRandMax() {
        return currentRandMax;
    }

    public void setCurrentRandMax(int currentRandMax) {
        this.currentRandMax = currentRandMax;
    }

    public int getCurrentRandMin() {
        return currentRandMin;
    }

    public void setCurrentRandMin(int currentRandMin) {
        this.currentRandMin = currentRandMin;
    }

    public void setRandNumber(int randNumber) {
        this.randNumber = randNumber;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}
