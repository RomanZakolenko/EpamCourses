package com.zakolenko.epam.project2.controller;

import com.zakolenko.epam.project2.view.ViewMessages;
import com.zakolenko.epam.project2.model.TextAnalyzer;
import com.zakolenko.epam.project2.model.entity.TextComposite;
import com.zakolenko.epam.project2.view.View;

import java.io.FileNotFoundException;

/**
 * An instance of this class is used for
 * parse the source text in the composite structure.
 *
 * @author Roman Zakolenko
 */
public class TextAnalyzeController {
    private TextAnalyzer textAnalyzer;
    private View view;

    /**
     * @param textAnalyzer which will parse the source text
     * @param view         for user interaction
     */
    public TextAnalyzeController(TextAnalyzer textAnalyzer, View view) {
        this.textAnalyzer = textAnalyzer;
        this.view = view;
    }

    /**
     * Parse source text by text analyzer and return composite structure.
     *
     * @return represent source text in composite structure
     */
    public TextComposite analyze() {
        TextComposite textComposite = null;
        try {
            textComposite = textAnalyzer.scan();
        } catch (FileNotFoundException e) {
            view.printMessage(ViewMessages.FILE, textAnalyzer.getFilePath(), ViewMessages.NOT_FOUND);
        }
        return textComposite;
    }
}
