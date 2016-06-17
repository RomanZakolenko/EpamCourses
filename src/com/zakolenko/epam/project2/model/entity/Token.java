package com.zakolenko.epam.project2.model.entity;

import com.zakolenko.epam.project2.model.TextNodeTypes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

/**
 * An instance of this class is used for representation code token.
 *
 * @author Roman Zakolenko
 */
public class Token extends TextComposite {
    private static Map<String, Token> tokens = new HashMap<>();

    public Token() {
    }

    /**
     * @param components list of child components
     */
    public Token(List<TextComponent> components) {
        super(components);
    }

    /**
     * @see TextComposite#addComponent(TextComponent)
     */
    @Override
    public boolean addComponent(TextComponent component) {
        if (TextNodeTypes.TOKEN.isContains(component.getClass())) {
            return super.addComponent(component);
        }
        return false;
    }

    /**
     * Static method of instance generating.
     *
     * @param value of token
     * @return instance of Token that which corresponds to a given value
     */
    public static Token valueOf(String value) {
        Token token = tokens.get(value);
        if (token == null) {
            List<TextComponent> components = new LinkedList<>();
            for (char ch : value.toCharArray()) {
                components.add(new Symbol(ch));
            }
            token = new Token(components);
            tokens.put(value, token);
        }
        return token;
    }
}
