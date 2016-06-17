package com.zakolenko.epam.project2.model;

import com.zakolenko.epam.project2.model.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This enumeration is used for settings of limitation on possible types
 * of argument in method TextComposite#addComponent(TextComponent).
 *
 * @see TextComposite#addComponent(TextComponent)
 */
public enum TextNodeTypes {
    PARAGRAPH(Sentence.class, Word.class, Symbol.class, PunctuationMark.class, Token.class),
    SENTENCE(Word.class, PunctuationMark.class, Symbol.class, Token.class),
    WORD(Symbol.class),
    TOKEN(Symbol.class);

    private List<Class> types;

    TextNodeTypes(Class... classes) {
        this.types = new ArrayList<>();
        for (Class clss : classes) {
            this.types.add(clss);
        }
    }

    /**
     * Checks that specified class is possible type as argument
     * in method TextComposite#addComponent(TextComponent).
     *
     * @param clss specified class
     * @return true, if specified class is possible type, otherwise false
     * @see TextComposite#addComponent(TextComponent)
     */
    public boolean isContains(Class clss) {
        return this.types.contains(clss);
    }
}
