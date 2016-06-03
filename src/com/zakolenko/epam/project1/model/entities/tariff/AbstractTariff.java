package com.zakolenko.epam.project1.model.entities.tariff;

import com.zakolenko.epam.project1.model.entities.User;
import com.zakolenko.epam.project1.model.entities.company.MobileCompany;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractTariff implements Tariff, Serializable {
    private String title;
    private double monthlyPrice;
    private MobileCompany mobileCompany;
    private List<User> users;

    public AbstractTariff() {
    }

    public AbstractTariff(String title, double monthlyPrice, MobileCompany mobileCompany, List<User> users) {
        this.title = title;
        this.monthlyPrice = monthlyPrice;
        this.mobileCompany = mobileCompany;
        this.users = users;
    }

    @Override
    public int getNumberOfClients() {
        return users.size();
    }

    @Override
    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    @Override
    public double getCallPrice(String number) {
        if (mobileCompany.hasNumber(number)) {
            return getCallPriceInsideNet();
        } else {
            return getCallPriceOutsideNet();
        }
    }

    public abstract double getCallPriceInsideNet();

    public abstract double getCallPriceOutsideNet();

    public void addUser(User user) {
        this.users.add(user);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public MobileCompany getMobileCompany() {
        return mobileCompany;
    }

    public void setMobileCompany(MobileCompany mobileCompany) {
        this.mobileCompany = mobileCompany;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof AbstractTariff)) return false;
        AbstractTariff tariff = (AbstractTariff) obj;
        if (Double.compare(tariff.monthlyPrice, monthlyPrice) != 0) return false;
        if (!title.equals(tariff.title)) return false;
        if (!mobileCompany.equals(tariff.mobileCompany)) return false;
        if (Double.compare(getCallPriceInsideNet(), tariff.getCallPriceInsideNet()) != 0) return false;
        return (Double.compare(getCallPriceOutsideNet(), tariff.getCallPriceOutsideNet()) == 0);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title.hashCode();
        temp = Double.doubleToLongBits(monthlyPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + mobileCompany.hashCode();
        temp = Double.doubleToLongBits(getCallPriceInsideNet());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCallPriceOutsideNet());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ title='" + title + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", mobileCompany=" + mobileCompany +
                ", callPriceInsideNet=" + getCallPriceInsideNet() +
                ", callPriceOutsideNet=" + getCallPriceOutsideNet() +
                '}';
    }
}
