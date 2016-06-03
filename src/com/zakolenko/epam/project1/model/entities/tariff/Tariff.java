package com.zakolenko.epam.project1.model.entities.tariff;

public interface Tariff {

    int getNumberOfClients();

    double getMonthlyPrice();

    double getCallPrice(String number);
}
