package com.zakolenko.epam.block06.labwork1.entities;

public class Motorcycle extends Vehicle {

    public Motorcycle(Vendor vendor, String licensePlate) {
        super(vendor, licensePlate);
    }

    @Override
    public void drive(Route route) {
        route.addVehicle(this);
        System.out.println(this + " goes on the " + route);
    }

    @Override
    public String toString() {
        return "Motorcycle{" + super.toString() + "}";
    }
}
