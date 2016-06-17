package com.zakolenko.epam.project2.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * An instance of this class is used for symbol representation.
 *
 * @author Roman Zakolenko
 */
public final class Symbol extends TextLeaf {
    private static Map<Character, Symbol> symbols = new HashMap<>();

    /**
     * @param value of symbol
     */
    public Symbol(char value) {
        super(value);
    }

    /**
     * Static method of instance generating.
     *
     * @param value of symbol
     * @return instance of Symbol that which corresponds to a given value
     */
    public static Symbol valueOf(char value) {
        if (!isSymbol(value)) {
            throw new IllegalArgumentException("'" + value + "' is not a symbol.");
        }
        Symbol symbol = symbols.get(value);
        if (symbol == null) {
            symbol = new Symbol(value);
            symbols.put(value, symbol);
        }
        return symbol;
    }

    /**
     * Checks whether a given char of symbol.
     *
     * @param symbol value of symbol
     * @return true, if symbol is symbol, otherwise false
     */
    public static boolean isSymbol(char symbol) {
        return Character.isDefined(symbol);
    }
}
