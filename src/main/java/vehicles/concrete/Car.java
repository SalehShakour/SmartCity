package vehicles.concrete;

import vehicles.interfaces.Vehicle;

import java.util.ArrayList;

public class Car implements Vehicle {
    static final double MAX_FUEL = 100.0;
    double positionX;
    double positionY;
    double fuel;
    Status engineStatus;
    Status gripSystemStatus;
    Plaque plaque;
    ArrayList<Boolean> tiresStatus;
    boolean retired;
    public static VehicleBuilder builder() {
        CarBuilder carBuilder = new CarBuilder();
        return carBuilder;
    }

    @Override
    public void move(double x, double y) {
        System.out.println("Car by plaque " + this.plaque + " Started moving from point ("
                + this.positionX + "," + this.positionY + ") to point ("
                + x + "," + y);
        this.positionX = x;
        this.positionY = y;
    }

    @Override
    public void horn(short time) {
        System.out.println("Car by plaque " + this.plaque + " Started horning for " + time + " seconds.");
    }

    @Override
    public void refuel(double fuel) {
        if (this.fuel >= MAX_FUEL) {
            System.out.println("Car by plaque " + this.plaque + " already refueled.");
        }
        this.fuel += fuel;
        if (this.fuel > MAX_FUEL) this.fuel = MAX_FUEL;
        System.out.println("Car by plaque " + this.plaque + " refueled, current fuel is " + this.fuel);
    }

    static class CarBuilder implements VehicleBuilder {
        private Car car;

        public CarBuilder() {
            this.car = new Car();
        }

        public CarBuilder positionX(double positionX) {
            this.car.positionX = positionX;
            return this;
        }

        public CarBuilder positionY(double positionY) {
            this.car.positionY = positionY;
            return this;
        }

        public CarBuilder fuel(double fuel) {
            this.car.fuel = fuel;
            return this;
        }

        public CarBuilder engineStatus(Status engineStatus) {
            this.car.engineStatus = engineStatus;
            return this;
        }

        public CarBuilder gripSystemStatus(Status gripSystemStatus) {
            this.car.gripSystemStatus = gripSystemStatus;
            return this;
        }

        public CarBuilder plaque(Plaque plaque) {
            this.car.plaque = plaque;
            return this;
        }

        public CarBuilder tiresStatus(ArrayList tiresStatus) {
            this.car.tiresStatus = tiresStatus;
            return this;
        }

        public CarBuilder retired(boolean retired){
            this.car.retired = retired;
            return this;
        }

        @Override
        public Vehicle build() {
            return this.car;
        }
    }
}
