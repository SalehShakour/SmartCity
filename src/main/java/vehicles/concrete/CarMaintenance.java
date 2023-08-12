package vehicles.concrete;

import vehicles.interfaces.Maintainance;
import vehicles.interfaces.Vehicle;

import java.util.ArrayList;

public class CarMaintenance implements Maintainance {
    private final Car car;

    public CarMaintenance(Car car) {
        this.car = car;
    }

    @Override
    public Maintainance refuel(double fuel) throws ArithmeticException {
        if (fuel < 0) throw new ArithmeticException("Fuel number can not be Negative");
        if (this.car.getFuel() < Car.MAX_FUEL) {
            this.car.refuel(fuel);
        }
        return this;
    }

    @Override
    public Maintainance repair() {
        if ((this.car.getGripSystemStatus() == Status.COUTION)
                || (this.car.getGripSystemStatus() == Status.DANGER)) {
            this.car.setGripSystemStatus(Status.GOOD);
        }
        if ((this.car.getEngineStatus() == Status.COUTION)
                || (this.car.getEngineStatus() == Status.DANGER)) {
            this.car.setEngineStatus(Status.GOOD);
        }
        for (int i = 0; i < this.car.getTiresStatus().size(); i++) {
            if (!this.car.getTiresStatus().get(i)) {
                ArrayList<Boolean> temp = this.car.getTiresStatus();
                temp.set(i, true);
                this.car.setTiresStatus(temp);
            }
        }
        return this;
    }

    @Override
    public void retire() {
        this.car.setRetired(true);
    }

    @Override
    public boolean compare(Vehicle vehicle) throws RuntimeException {
        if (!(vehicle instanceof Car)) {
            throw new RuntimeException();
        }
        //This line only shows off the polymorphism, the parameter can be any number
        vehicle.refuel(Car.MAX_FUEL);
        Car newCar = (Car) vehicle;
        return (this.car.getEngineStatus() == newCar.getEngineStatus()) ? true : false;
    }
}
