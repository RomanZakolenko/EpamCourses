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
        this.currentRandMin = min;
        this.currentRandMax = max;
        return new Random().nextInt(max - min - 1) + min + 1;
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
    public boolean compareWithRandNumber(int number) {
        if (randNumber == number) {
            return true;
        } else {
            if (number < randNumber) {
                currentRandMin = number;
            } else {
                currentRandMax = number;
            }
            return false;
        }
    }

    public void addToNumberOfAttempts(int value) {
        this.numberOfAttempts += value;
    }

    public int getCurrentRandMax() {
        return currentRandMax;
    }

    public int getCurrentRandMin() {
        return currentRandMin;
    }

    public void setRandNumber(int randNumber) {
        this.randNumber = randNumber;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
