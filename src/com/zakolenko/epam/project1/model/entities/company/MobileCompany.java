package com.zakolenko.epam.project1.model.entities.company;

import com.zakolenko.epam.project1.model.entities.tariff.Tariff;

import java.util.Set;

public interface MobileCompany {
    String PHONE_NUMBER_REGEX = "^\\+?(3\\-?8\\-?)?((\\(\\d{3}\\))|(\\d{3}))\\-?\\d{3}\\-?\\d{2}\\-?\\d{2}$";

    int getNumberOfClients();

    Set<Tariff> getTariffs();

    boolean hasNumber(String number);
}
