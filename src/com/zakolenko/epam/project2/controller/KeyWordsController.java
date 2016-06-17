package com.zakolenko.epam.project2.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * An  instance of this class is used to the initialization set of keywords.
 *
 * @author Roman Zakolenko
 */
public class KeyWordsController {

    /**
     * It creates a set of key words by reading them from a file.
     *
     * @param filePath of file, that contains keywords
     * @return set of keywords
     */
    public Set<String> getKeyWords(String filePath) {
        Set<String> keyWords = new HashSet<>();
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)))) {
            while (sc.hasNext()) {
                keyWords.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return keyWords;
    }
}
