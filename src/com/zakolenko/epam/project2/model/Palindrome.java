package com.zakolenko.epam.project2.model;

import java.util.Arrays;

/**
 * An instance of this class is used for find longest palindrome in specified string.
 * For find longest palindrome used Manacher algorithm.
 */
public class Palindrome {

    /**
     * Find and return longest palindrome in specified string.
     *
     * @param string is specified string
     * @return longest palindrome
     */
    public String findLongestPalindrome(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Specific string is null or empty.");
        }
        char[] bordersStr = addBorders(string.toCharArray());
        int[] palindromeRadius = new int[bordersStr.length];
        int centreOfPalindrome = 0;
        int rightBorders = 0;
        int i = 0;
        int j = 0;
        for (int index = 1; index < bordersStr.length; index++) {
            if (index > rightBorders) {
                palindromeRadius[index] = 0;
                i = index - 1;
                j = index + 1;
            } else {
                int mirrorIndex = centreOfPalindrome * 2 - index;
                if (palindromeRadius[mirrorIndex] < (rightBorders - index)) {
                    palindromeRadius[index] = palindromeRadius[mirrorIndex];
                    i = -1;
                } else {
                    palindromeRadius[index] = rightBorders - index;
                    j = rightBorders + 1;
                    i = index * 2 - j;
                }
            }
            while (i >= 0 && j < bordersStr.length && bordersStr[i] == bordersStr[j]) {
                palindromeRadius[index]++;
                i--;
                j++;
            }
            if ((index + palindromeRadius[index]) > rightBorders) {
                centreOfPalindrome = index;
                rightBorders = index + palindromeRadius[index];
            }
        }
        int size = 0;
        centreOfPalindrome = 0;
        for (int k = 1; k < bordersStr.length; k++) {
            if (size < palindromeRadius[k]) {
                size = palindromeRadius[k];
                centreOfPalindrome = k;
            }
        }
        char[] newStr = Arrays.copyOfRange(bordersStr, centreOfPalindrome - size, centreOfPalindrome + size + 1);
        return String.valueOf(removeBorders(newStr));
    }

    private char[] addBorders(char[] str) {
        char[] strWithBorders = new char[str.length * 2 + 1];
        for (int i = 0; i < strWithBorders.length - 1; i += 2) {
            strWithBorders[i] = '|';
            strWithBorders[i + 1] = str[i / 2];
        }
        strWithBorders[strWithBorders.length - 1] = '|';
        return strWithBorders;
    }

    private char[] removeBorders(char[] str) {
        char[] strWithoutBorders = new char[(str.length - 1) / 2];
        for (int i = 0; i < strWithoutBorders.length; i++) {
            strWithoutBorders[i] = str[i * 2 + 1];
        }
        return strWithoutBorders;
    }
}
