package com.zakolenko.epam.project2.model.entity;

import com.zakolenko.epam.project2.model.TextNodeTypes;

import java.util.List;

/**
 * An instance of this class is used for sentence representation.
 * It may contain words, symbols and punctuation marks.
 *
 * @author Roman Zakolenko
 */
public class Sentence extends TextComposite {
    /**
     * Regular expression describing the sentence.
     */
    public static final String SENTENCE_REGEX = "[^.!?]*[.!?]";

    public Sentence() {
    }

    /**
     * @param components list of child components
     */
    public Sentence(List<TextComponent> components) {
        super(components);
    }

    /**
     * @see TextComposite#addComponent(TextComponent)
     */
    @Override
    public boolean addComponent(TextComponent component) {
        if (TextNodeTypes.SENTENCE.isContains(component.getClass())) {
            return super.addComponent(component);
        }
        return false;
    }
}
