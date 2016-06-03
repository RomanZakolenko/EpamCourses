package com.zakolenko.epam.project1.model;

import com.zakolenko.epam.project1.model.entities.company.MobileCompany;
import com.zakolenko.epam.project1.model.entities.tariff.Tariff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    public int getNumberOfClients(MobileCompany company) {
        return company.getNumberOfClients();
    }

    public List<Tariff> sortTariffsByMonthlyPrice(MobileCompany company) {
        return company.getTariffs().stream().
                sorted((t1, t2) -> Double.compare(t1.getMonthlyPrice(), t2.getMonthlyPrice())).
                collect(Collectors.toList());
    }

    public List<? extends Tariff> getTariffsByMontlyPrice(MobileCompany company, double min, double max) {
        TariffFilter filter = new TariffFilter(t -> t.getMonthlyPrice() >= min && t.getMonthlyPrice() <= max);
        return filter.filter(new ArrayList<>(company.getTariffs()));
    }

    public List<? extends Tariff> getTariffsByNumberOfClients(MobileCompany company, int min, int max) {
        TariffFilter filter = new TariffFilter(t -> t.getNumberOfClients() >= min && t.getNumberOfClients() <= max);
        return filter.filter(new ArrayList<>(company.getTariffs()));
    }

    public List<? extends Tariff> getTariffsByFilter(MobileCompany company, TariffFilter tariffFilter) {
        return tariffFilter.filter(new ArrayList<>(company.getTariffs()));
    }
}