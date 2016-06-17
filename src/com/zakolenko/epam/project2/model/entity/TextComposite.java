package com.zakolenko.epam.project2.model.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to create a composite structure for the text.
 */
public class TextComposite extends TextComponent implements Iterable<TextComponent> {
    private List<TextComponent> components;

    public TextComposite() {
        this.components = new LinkedList<>();
    }

    /**
     * @param components list of child components
     */
    public TextComposite(List<TextComponent> components) {
        this.components = components;
    }

    /**
     * @see TextComponent#getValue()
     */
    @Override
    public String getValue() {
        StringBuilder value = new StringBuilder();
        components.forEach(component -> value.append(component.getValue()));
        return value.toString();
    }

    /**
     * Add a child component.
     *
     * @param component child component
     * @return true, if component is added, otherwise false
     */
    public boolean addComponent(TextComponent component) {
        return components.add(component);
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return components.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof TextComponent)) return false;
        TextComposite composite = (TextComposite) obj;
        return components.equals(composite.components);
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{components=" + components +
                '}';
    }
}