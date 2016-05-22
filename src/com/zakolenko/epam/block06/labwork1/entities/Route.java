package com.zakolenko.epam.block06.labwork1.entities;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String title;
    private List<Vehicle> vehicles;

    public Route(String title) {
        this.title = title;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public int getNumberOfVehicles() {
        return vehicles.size();
    }

    public int getNumberOfFreightCar() {
        return (int) vehicles.stream().filter(vehicle -> vehicle.getClass() == FreightCar.class).count();
    }

    public int getNumberOfPassengerCar() {
        return (int) vehicles.stream().filter(vehicle -> vehicle.getClass() == PassengerCar.class).count();
    }

    public int getNumberOfMotorcycle() {
        return (int) vehicles.stream().filter(vehicle -> vehicle.getClass() == Motorcycle.class).count();
    }

    public boolean isPassed(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Route route = (Route) obj;
        if (!title.equals(route.title)) return false;
        return vehicles.equals(route.vehicles);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + vehicles.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Route{title='" + title + '\'' + '}';
    }
}
