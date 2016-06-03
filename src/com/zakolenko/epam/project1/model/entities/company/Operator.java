package com.zakolenko.epam.project1.model.entities.company;

import com.zakolenko.epam.project1.model.entities.tariff.Tariff;

import java.util.HashSet;
import java.util.Set;

public enum Operator implements MobileCompany {

    KYIVSTAR("39", "67", "68", "96", "97", "98"),
    MTS("50", "66", "95", "99");

    private Set<String> operatorCodes = new HashSet<>();
    private Set<Tariff> tariffs = new HashSet<>();

    Operator(String... operatorCodes) {
        for (String code : operatorCodes) {
            this.operatorCodes.add(code);
        }
    }

    @Override
    public int getNumberOfClients() {
        return tariffs.stream().mapToInt(t -> t.getNumberOfClients()).sum();
    }

    @Override
    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public boolean addOperatorCodes(String code) {
        return operatorCodes.add(code);
    }

    public boolean addTariff(Tariff tariff) {
        return tariffs.add(tariff);
    }

    public boolean hasNumber(String number) {
        number = number.replaceAll("[-()]", "");
        String code = number.substring(0, number.length() - 7);
        for (String opCode : operatorCodes) {
            if (code.contains(opCode)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> getOperatorCodes() {
        return operatorCodes;
    }

    public void setOperatorCodes(Set<String> operatorCodes) {
        this.operatorCodes = operatorCodes;
    }

    public void setTariffs(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }
}
