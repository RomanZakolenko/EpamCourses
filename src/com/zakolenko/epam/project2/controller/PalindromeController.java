package com.zakolenko.epam.project2.controller;

import com.zakolenko.epam.project2.model.Palindrome;
import com.zakolenko.epam.project2.model.entity.TextComposite;
import com.zakolenko.epam.project2.view.View;
import com.zakolenko.epam.project2.view.ViewMessages;

/**
 * The instance of this class is used to find the maximum palindrome string
 * in a specified text.
 *
 * @author Roman Zakolenko
 */
public class PalindromeController {
    private TextComposite textComposite;
    private View view;

    /**
     * @param textComposite contains composite structure of text
     * @param view          for user interaction
     */
    public PalindromeController(TextComposite textComposite, View view) {
        this.textComposite = textComposite;
        this.view = view;
    }

    /**
     * Find and print for user the maximum palindrome string
     * in specified text.
     */
    public void printLongestPalindrome() {
        Palindrome palindrome = new Palindrome();
        String text = textComposite.getValue();
        view.printMessage(ViewMessages.TEXT);
        view.printMessage(text);
        view.printMessage(ViewMessages.LONGEST_PALINDROME, palindrome.findLongestPalindrome(text));
    }
}
