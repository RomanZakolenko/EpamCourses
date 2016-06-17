package com.zakolenko.epam.project2.model.entity;

/**
 * This class is used for representation leaf element of text component.
 *
 * @author Roman Zakolenko
 */
public abstract class TextLeaf extends TextComponent {
    private final char value;

    /**
     * @param value of text leaf
     */
    public TextLeaf(char value) {
        this.value = value;
    }

    /**
     * @see TextComponent#getValue()
     */
    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof TextLeaf)) return false;
        TextLeaf textLeaf = (TextLeaf) obj;
        return value == textLeaf.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }
}
