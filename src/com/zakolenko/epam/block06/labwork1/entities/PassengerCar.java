package com.zakolenko.epam.block06.labwork1.entities;

public class PassengerCar extends Vehicle {
    private int passengerCapacity;

    public PassengerCar(Vendor vendor, String licensePlate, int passengerCapacity) {
        super(vendor, licensePlate);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void drive(Route route) {
        route.addVehicle(this);
        System.out.println(this + " goes on the " + route);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PassengerCar passengerCar = (PassengerCar) obj;
        return passengerCapacity == passengerCar.passengerCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "PassengerCar{" + super.toString() + ", " +
                "passengerCapacity=" + passengerCapacity +
                '}';
    }
}
