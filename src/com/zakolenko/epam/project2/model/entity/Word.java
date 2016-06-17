package com.zakolenko.epam.project2.model.entity;

import com.zakolenko.epam.project2.model.TextNodeTypes;

import java.util.List;

/**
 * An instance of this class is used for word representation.
 *
 * @author Roman Zakolenko
 */
public class Word extends TextComposite {
    /**
     * Regular expression describing the word.
     */
    public static final String WORD_REGEX = "[^\\s,:;.!?-]+";

    public Word() {
    }

    /**
     * @param components list of child components
     */
    public Word(List<TextComponent> components) {
        super(components);
    }

    /**
     * @see TextComponent#getValue()
     */
    @Override
    public String getValue() {
        return " " + super.getValue();
    }

    /**
     * @see TextComposite#addComponent(TextComponent)
     */
    @Override
    public boolean addComponent(TextComponent component) {
        if (TextNodeTypes.WORD.isContains(component.getClass())) {
            return super.addComponent(component);
        }
        return false;
    }
}
