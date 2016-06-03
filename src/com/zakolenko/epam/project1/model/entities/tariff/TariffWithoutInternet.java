package com.zakolenko.epam.project1.model.entities.tariff;

import com.zakolenko.epam.project1.model.entities.User;
import com.zakolenko.epam.project1.model.entities.company.MobileCompany;

import java.util.List;

public class TariffWithoutInternet extends AbstractTariff {
    private double callPriceInsideNet;
    private double callPriceOutsideNet;

    public TariffWithoutInternet() {
    }

    public TariffWithoutInternet(String title, double monthlyPrice, MobileCompany mobileCompany,
                                 List<User> users, double callPriceInsideNet, double callPriceOutsideNet) {
        super(title, monthlyPrice, mobileCompany, users);
        this.callPriceInsideNet = callPriceInsideNet;
        this.callPriceOutsideNet = callPriceOutsideNet;
    }

    @Override
    public double getCallPriceInsideNet() {
        return callPriceInsideNet;
    }

    @Override
    public double getCallPriceOutsideNet() {
        return callPriceOutsideNet;
    }

    public void setCallPriceInsideNet(double callPriceInsideNet) {
        this.callPriceInsideNet = callPriceInsideNet;
    }

    public void setCallPriceOutsideNet(double callPriceOutsideNet) {
        this.callPriceOutsideNet = callPriceOutsideNet;
    }
}
