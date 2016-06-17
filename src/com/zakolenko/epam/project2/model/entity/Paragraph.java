package com.zakolenko.epam.project2.model.entity;

import com.zakolenko.epam.project2.model.TextNodeTypes;

import java.util.List;

/**
 * An instance of this class is used for paragraph representation.
 * It may contain sentences, words, symbols and punctuation marks.
 */
public class Paragraph extends TextComposite {

    public Paragraph() {
    }

    /**
     * @param components list of child component
     */
    public Paragraph(List<TextComponent> components) {
        super(components);
    }

    /**
     * @see TextComponent#getValue()
     */
    @Override
    public String getValue() {
        return " " + super.getValue() + "\n";
    }

    /**
     * @see TextComposite#addComponent(TextComponent)
     */
    @Override
    public boolean addComponent(TextComponent component) {
        if (TextNodeTypes.PARAGRAPH.isContains(component.getClass())) {
            return super.addComponent(component);
        }
        return false;
    }
}
