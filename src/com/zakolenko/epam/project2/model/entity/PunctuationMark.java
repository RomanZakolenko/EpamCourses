package com.zakolenko.epam.project2.model.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * An instance of this class is used for representation punctuation mark.
 *
 * @author Roman Zakolenko
 */
public final class PunctuationMark extends TextLeaf {
    /**
     * Regular expression describing the punctuation mark.
     */
    public static final String PUNCTUATION_MARK_REGEX = "[.,-:;!?\"<>]";
    private static Map<Character, PunctuationMark> punctuationMarks = new HashMap<>();

    /**
     * @param value of punctuation mark
     */
    public PunctuationMark(char value) {
        super(value);
    }

    /**
     * Static method of instance generating.
     *
     * @param key value of punctuation mark
     * @return instance of PunctuationMark that which corresponds to a given key
     */
    public static PunctuationMark valueOf(char key) {
        if (!isPunctuationMark(key)) {
            throw new IllegalArgumentException("'" + key + "' is not a punctuation mark.");
        }
        PunctuationMark punctMark = punctuationMarks.get(key);
        if (punctMark == null) {
            punctMark = new PunctuationMark(key);
            punctuationMarks.put(key, punctMark);
        }
        return punctMark;
    }

    /**
     * Checks whether a given char of punctuation mark
     *
     * @param punctMark punctuation mark
     * @return true, if punctMark is punctuation mark, otherwise false
     */
    public static boolean isPunctuationMark(char punctMark) {
        return Pattern.matches(PUNCTUATION_MARK_REGEX, String.valueOf(punctMark));
    }

    /**
     * Checks whether a given string of punctuation mark
     *
     * @param punctMark punctuation mark
     * @return true, if punctMark is punctuation mark, otherwise false
     */
    public static boolean isPunctuationMark(String punctMark) {
        if (punctMark == null || punctMark.isEmpty() || punctMark.length() > 1) {
            return false;
        }
        return isPunctuationMark(punctMark.charAt(0));
    }
}

