package com.zakolenko.epam.project2.model;

import com.zakolenko.epam.project2.model.entity.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An instance of this class is used for parsing text
 * in composite structure.
 *
 * @author Roman Zakolenko
 */
public class TextAnalyzer {
    /**
     * Regular expression describing the tabulation.
     */
    public static final String TAB_REGEX = "\\s{4,}";
    private String filePath;
    private Pattern sentencePattern;
    private Pattern tokenPattern;
    private Set<String> keyWords;

    /**
     * @param filePath file path
     * @param keyWords set of keywords for parsing code token
     */
    public TextAnalyzer(String filePath, Set<String> keyWords) {
        this.filePath = filePath;
        this.sentencePattern = Pattern.compile(Sentence.SENTENCE_REGEX);
        this.tokenPattern = Pattern.compile("(" + Word.WORD_REGEX + ")|(" + PunctuationMark.PUNCTUATION_MARK_REGEX + ")");
        this.keyWords = keyWords;
    }

    /**
     * Scan specified text and return composite structure of this text.
     *
     * @return composite structure of specified text
     * @throws FileNotFoundException
     */
    public TextComposite scan() throws FileNotFoundException {
        TextComposite textComposite = new TextComposite();
        try (Scanner textScanner = new Scanner(new BufferedReader(new FileReader(filePath)))) {
            textScanner.useDelimiter(TAB_REGEX);
            while (textScanner.hasNext()) {
                textComposite.addComponent(nextParagraph(textScanner.next()));
            }
        }
        return textComposite;
    }

    public String getFilePath() {
        return filePath;
    }

    public Pattern getSentencePattern() {
        return sentencePattern;
    }

    public void setSentencePattern(Pattern sentencePattern) {
        this.sentencePattern = sentencePattern;
    }

    public Pattern getTokenPattern() {
        return tokenPattern;
    }

    public void setTokenPattern(Pattern tokenPattern) {
        this.tokenPattern = tokenPattern;
    }

    private Paragraph nextParagraph(String string) {
        Paragraph paragraph = new Paragraph();
        Matcher sentenceMatcher = sentencePattern.matcher(string);
        while (sentenceMatcher.find()) {
            paragraph.addComponent(nextSentence(sentenceMatcher.group()));
        }
        return paragraph;
    }

    private Sentence nextSentence(String string) {
        Sentence sentence = new Sentence();
        Matcher tokenMatcher = tokenPattern.matcher(string);
        while (tokenMatcher.find()) {
            sentence.addComponent(nextToken(tokenMatcher.group()));
        }
        return sentence;
    }

    private TextComponent nextToken(String string) {
        if (PunctuationMark.isPunctuationMark(string)) {
            return new PunctuationMark(string.charAt(0));
        } else {
            if (keyWords.contains(string)) {
                return Token.valueOf(string);
            } else {
                Word word = new Word();
                for (char symbol : string.toCharArray()) {
                    word.addComponent(Symbol.valueOf(symbol));
                }
                return word;
            }
        }
    }
}