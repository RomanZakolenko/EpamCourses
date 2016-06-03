package com.zakolenko.epam.project1.model.entities;

import com.zakolenko.epam.project1.model.entities.company.MobileCompany;
import com.zakolenko.epam.project1.model.entities.tariff.Tariff;

import java.io.Serializable;
import java.util.regex.Pattern;

public class User implements Serializable {
    private double balance;
    private String phoneNumber;
    private Tariff tariff;

    public User() {
    }

    public User(double balance, String phoneNumber, Tariff tariff) {
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    public boolean call(String phoneNumber) {
        String number = deleteSpaces(phoneNumber);
        boolean isValidNumber = Pattern.matches(MobileCompany.PHONE_NUMBER_REGEX, number);
        if (isValidNumber) {
            balance -= tariff.getCallPrice(number);
        }
        return isValidNumber;
    }

    public void refillBalance(double balance) {
        this.balance += balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tariff=" + tariff +
                '}';
    }

    private String deleteSpaces(String number) {
        return number.replaceAll("\\s+", "");
    }
}
