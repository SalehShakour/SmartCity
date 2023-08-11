package vehicles.concrete;

import vehicles.interfaces.Vehicle;


public class Train implements Vehicle {
    static final double MAX_FUEL = 300.0;
    private static Train train;
    double positionX;
    double positionY;
    double fuel;
    Status engineStatus;
    boolean retired;
    private Train() {
    }

    public static synchronized Train getTrain() {
        if (Train.train == null) {
            Train.train = new Train();
        }
        return Train.train;
    }

    public static VehicleBuilder builder() {
        TrainBuilder trainBuilder = new TrainBuilder();
        return trainBuilder;
    }

    @Override
    public void move(double x, double y) {
        System.out.println("train Started moving from point ("
                + this.positionX + "," + this.positionY + ") to point ("
                + x + "," + y);
        this.positionX = x;
        this.positionY = y;
    }

    @Override
    public void horn(short time) {
        System.out.println("the train Started horning for " + time + " seconds.");
    }

    @Override
    public void refuel(double fuel) {
        if (this.fuel >= MAX_FUEL) {
            System.out.println("train already refueled.");
        }
        this.fuel += fuel;
        if (this.fuel > MAX_FUEL) this.fuel = MAX_FUEL;
        System.out.println("train refueled, current fuel is " + this.fuel);
    }

    static class TrainBuilder implements VehicleBuilder {
        private Train train;

        public TrainBuilder() {
            this.train = Train.getTrain();
        }

        public TrainBuilder positionX(double positionX) {
            this.train.positionX = positionX;
            return this;
        }

        public TrainBuilder positionY(double positionY) {
            this.train.positionY = positionY;
            return this;
        }

        public TrainBuilder fuel(double fuel) {
            this.train.fuel = fuel;
            return this;
        }

        public TrainBuilder engineStatus(Status engineStatus) {
            this.train.engineStatus = engineStatus;
            return this;
        }

        public TrainBuilder retired(boolean retired) {
            this.train.retired = retired;
            return this;
        }

        @Override
        public Vehicle build() {
            return this.train;
        }
    }
}
