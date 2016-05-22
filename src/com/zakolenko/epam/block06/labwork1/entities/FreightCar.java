package com.zakolenko.epam.block06.labwork1.entities;

public class FreightCar extends Vehicle {
    private double cargoIntensity;

    public FreightCar(Vendor vendor, String licensePlate, double cargoIntensity) {
        super(vendor, licensePlate);
        this.cargoIntensity = cargoIntensity;
    }

    @Override
    public void drive(Route route) {
        route.addVehicle(this);
        System.out.println(this + " goes on the " + route);
    }

    public double getCargoIntensity() {
        return cargoIntensity;
    }

    public void setCargoIntensity(double cargoIntensity) {
        this.cargoIntensity = cargoIntensity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        FreightCar freightCar = (FreightCar) obj;
        return Double.compare(freightCar.cargoIntensity, cargoIntensity) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(cargoIntensity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "FreightCar{" + super.toString() + ", " +
                "cargoIntensity=" + cargoIntensity +
                '}';
    }
}
