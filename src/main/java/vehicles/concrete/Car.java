package vehicles.concrete;

import vehicles.interfaces.Vehicle;

import java.util.ArrayList;

/**
 * <h1>Car class</h1>
 * This class implements the vehicle concept and is supposed to present a car and its possible
 * methods, attribute, etc.
 */
public class Car implements Vehicle {
    static final double MAX_FUEL = 100.0;
    private Engine CarEngine;
    private double positionX;
    private double positionY;
    private double fuel;
    private Status engineStatus;
    private Status gripSystemStatus;
    private Plaque plaque;
    private ArrayList<Boolean> tiresStatus;
    private boolean retired;

    /**
     * This method is designed to return the builder object that will be used to build and set up
     * car objects.
     *
     * @return The builder object
     */
    public static VehicleBuilder builder() {
        CarBuilder carBuilder = new CarBuilder();
        return carBuilder;
    }

    @Override
    public void move(double x, double y) {
        System.out.println("Car by plaque " + this.getPlaque() + " Started moving from point ("
                + this.getPositionX() + "," + this.getPositionY() + ") to point ("
                + x + "," + y);
        this.setPositionX(x);
        this.setPositionY(y);
    }

    @Override
    public void horn(short time) {
        System.out.println("Car by plaque " + this.getPlaque() + " Started horning for " + time + " seconds.");
    }

    @Override
    public void refuel(double fuel) {
        if (this.getFuel() >= MAX_FUEL) {
            System.out.println("Car by plaque " + this.getPlaque() + " already refueled.");
        }
        this.setFuel(this.getFuel() + fuel);
        if (this.getFuel() > MAX_FUEL) this.setFuel(MAX_FUEL);
        System.out.println("Car by plaque " + this.getPlaque() + " refueled, current fuel is " + this.getFuel());
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public Status getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(Status engineStatus) {
        this.engineStatus = engineStatus;
    }

    public Status getGripSystemStatus() {
        return gripSystemStatus;
    }

    public void setGripSystemStatus(Status gripSystemStatus) {
        this.gripSystemStatus = gripSystemStatus;
    }

    public Plaque getPlaque() {
        return plaque;
    }

    public void setPlaque(Plaque plaque) {
        this.plaque = plaque;
    }

    public ArrayList<Boolean> getTiresStatus() {
        return tiresStatus;
    }

    public void setTiresStatus(ArrayList<Boolean> tiresStatus) {
        this.tiresStatus = tiresStatus;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public Engine getCarEngine() {
        return CarEngine;
    }

    public void setCarEngine(Engine carEngine) {
        CarEngine = carEngine;
    }

    /**
     * <h1>Implementing Car builder class will be used to set up car objects.</h1>
     */
    static class CarBuilder implements VehicleBuilder {
        private Car car;

        public CarBuilder() {
            this.car = new Car();
        }

        public CarBuilder positionX(double positionX) {
            this.car.setPositionX(positionX);
            return this;
        }

        public CarBuilder positionY(double positionY) {
            this.car.setPositionY(positionY);
            return this;
        }

        public CarBuilder fuel(double fuel) {
            this.car.setFuel(fuel);
            return this;
        }

        public CarBuilder engineStatus(Status engineStatus) {
            this.car.setEngineStatus(engineStatus);
            return this;
        }

        public CarBuilder gripSystemStatus(Status gripSystemStatus) {
            this.car.setGripSystemStatus(gripSystemStatus);
            return this;
        }

        public CarBuilder plaque(Plaque plaque) {
            this.car.setPlaque(plaque);
            return this;
        }

        public CarBuilder tiresStatus(ArrayList<Boolean> tiresStatus) {
            this.car.setTiresStatus(tiresStatus);
            return this;
        }

        public CarBuilder engine(Engine engine) throws RuntimeException {
            if (engine instanceof CarEngine) {
                this.car.setCarEngine(engine);
                return this;
            } else {
                throw new RuntimeException();
            }
        }

        public CarBuilder retired(boolean retired) {
            this.car.setRetired(retired);
            return this;
        }

        @Override
        public Vehicle build() {
            return this.car;
        }
    }
}
