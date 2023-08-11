package vehicles.concrete;

import vehicles.interfaces.Maintainance;

public class CarMaintenance implements Maintainance {
    private final Car car;

    public CarMaintenance(Car car) {
        this.car = car;
    }

    @Override
    public Maintainance refuel(double fuel) throws ArithmeticException {
        if (fuel < 0) throw new ArithmeticException("Fuel number can not be Negative");
        if (this.car.fuel < Car.MAX_FUEL) {
            this.car.refuel(fuel);
        }
        return this;
    }

    @Override
    public Maintainance repair() {
        if ((this.car.gripSystemStatus == Status.COUTION)
                || (this.car.gripSystemStatus == Status.DANGER)) {
            this.car.gripSystemStatus = Status.GOOD;
        }
        if ((this.car.engineStatus == Status.COUTION)
                || (this.car.engineStatus == Status.DANGER)) {
            this.car.engineStatus = Status.GOOD;
        }
        for (int i = 0; i < this.car.tiresStatus.size(); i++) {
            if (this.car.tiresStatus.get(i) == false) {
                this.car.tiresStatus.set(i, true);
            }
        }
        return this;
    }

    @Override
    public void retire() {
        this.car.retired = true;
    }
}
