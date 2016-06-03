package com.zakolenko.epam.project1.model.entities.tariff;

import com.zakolenko.epam.project1.model.entities.User;
import com.zakolenko.epam.project1.model.entities.company.MobileCompany;

import java.util.List;

public class TariffWithInternet extends AbstractTariff {
    private AbstractTariff tariff;
    private double internetPrice;

    public TariffWithInternet() {
    }

    public TariffWithInternet(String title, double monthlyPrice, MobileCompany mobileCompany,
                              List<User> users, AbstractTariff tariff, double internetPrice) {
        super(title, monthlyPrice, mobileCompany, users);
        this.tariff = tariff;
        this.internetPrice = internetPrice;
    }

    @Override
    public double getCallPriceInsideNet() {
        return tariff.getCallPriceInsideNet();
    }

    @Override
    public double getCallPriceOutsideNet() {
        return tariff.getCallPriceOutsideNet();
    }


    public AbstractTariff getTariff() {
        return tariff;
    }

    public void setTariff(AbstractTariff tariff) {
        this.tariff = tariff;
    }

    public void setInternetPrice(double internetPrice) {
        this.internetPrice = internetPrice;
    }

    public double getInternetPrice() {
        return internetPrice;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", internetPrice=" + getInternetPrice();
    }
}