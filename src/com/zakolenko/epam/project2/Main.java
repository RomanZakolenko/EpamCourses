package com.zakolenko.epam.project2;

import com.zakolenko.epam.project2.controller.KeyWordsController;
import com.zakolenko.epam.project2.controller.PalindromeController;
import com.zakolenko.epam.project2.controller.TextAnalyzeController;
import com.zakolenko.epam.project2.model.TextAnalyzer;
import com.zakolenko.epam.project2.view.View;

import static com.zakolenko.epam.project2.controller.config.Config.*;

public class Main {
    public static void main(String[] args) {
        KeyWordsController keyWordsController = new KeyWordsController();
        TextAnalyzer textAnalyzer = new TextAnalyzer(CONFIG.getFilePath(), keyWordsController.getKeyWords(CONFIG.getKeyWords()));
        View view = new View();
        TextAnalyzeController textAnalyzeController = new TextAnalyzeController(textAnalyzer, view);
        PalindromeController palindromeController = new PalindromeController(textAnalyzeController.analyze(), view);
        palindromeController.printLongestPalindrome();
    }
}
