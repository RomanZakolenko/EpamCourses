package com.zakolenko.epam.block06.labwork1;

import com.zakolenko.epam.block06.labwork1.entities.*;

public class Main {
    public static void main(String[] args) {
        Route route = new Route("Route 17");
        Vehicle[] vehicles = new Vehicle[]{new FreightCar(Vendor.BMW, "1234", 1000),
                new FreightCar(Vendor.CHEVROLET, "4321", 500),
                new PassengerCar(Vendor.TOYOTA, "8888", 4),
                new Motorcycle(Vendor.YAMAHA, "СА 234-34 В")};
        for (Vehicle vehicle : vehicles) {
            vehicle.drive(route);
        }
        System.out.println("The number of vehicles to drive on the road = " + route.getNumberOfVehicles());
        System.out.println("The number of freight cars to drive on the road = " + route.getNumberOfFreightCar());
        System.out.println("The number of passenger cars to drive on the road = " + route.getNumberOfPassengerCar());
        System.out.println("The number of motorcycles to drive on the road = " + route.getNumberOfMotorcycle());
        System.out.println("Whether " + vehicles[3] + " rides on the road = " + route.isPassed(vehicles[3]));
    }
}
