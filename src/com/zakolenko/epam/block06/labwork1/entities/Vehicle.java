package com.zakolenko.epam.block06.labwork1.entities;

public abstract class Vehicle {
    private Vendor vendor;
    private String licensePlate;

    public Vehicle(Vendor vendor, String licensePlate) {
        this.vendor = vendor;
        this.licensePlate = licensePlate;
    }

    public abstract void drive(Route route);

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        if (vendor != vehicle.vendor) return false;
        return licensePlate.equals(vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        int result = vendor.hashCode();
        result = 31 * result + licensePlate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vendor=" + vendor +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
