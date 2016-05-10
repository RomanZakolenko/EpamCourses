package com.zakolenko.epam.block03.labwork.model;

/**
 * This class is used to enumerate the possible groups of people in the notebook.
 *
 * @author Roman Zakolenko
 */
public enum Group {
    FRIENDS, FAMILY, COLLEGES;

    /**
     * Returns the class instance of its serial number.
     *
     * @param ordinal serial number
     * @return instance of Group with specified ordinal
     */
    public static Group getByOrdinal(int ordinal) {
        return values()[ordinal];
    }
}
