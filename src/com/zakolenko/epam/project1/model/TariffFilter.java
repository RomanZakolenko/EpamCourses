package com.zakolenko.epam.project1.model;

import com.zakolenko.epam.project1.model.entities.tariff.Tariff;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TariffFilter {
    private Predicate<Tariff> predicate;
    private TariffFilter nextFilter;

    public TariffFilter(Predicate<Tariff> predicate) {
        this.predicate = predicate;
    }

    public void setNextFilter(TariffFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public List<? extends Tariff> filter(List<? extends Tariff> tariffs) {
        List<? extends Tariff> filtered = tariffs.stream().filter(predicate).collect(Collectors.toList());
        if (nextFilter != null) {
            return nextFilter.filter(filtered);
        }
        return filtered;
    }
}
