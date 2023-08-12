package vehicles.concrete;

import vehicles.interfaces.Vehicle;

/**
 * <h1>Train class</h1>
 * This class will be representing the train entity which(in our imaginery smart city) is consisting
 * of only 1 train, meaning that our city does not have any more trains than 1. So we must never have
 * more than one train, therefore we use the design pattern of "Singleton"
 */
public class Train implements Vehicle {
    static final double MAX_FUEL = 300.0;
    private static Train train;
    private double positionX;
    private double positionY;
    private double fuel;
    private Status engineStatus;
    private boolean retired;

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

    public static void setTrain(Train train) {
        Train.train = train;
    }

    @Override
    public void move(double x, double y) {
        System.out.println("train Started moving from point ("
                + this.getPositionX() + "," + this.getPositionY() + ") to point ("
                + x + "," + y);
        this.setPositionX(x);
        this.setPositionY(y);
    }

    @Override
    public void horn(short time) {
        System.out.println("the train Started horning for " + time + " seconds.");
    }

    @Override
    public void refuel(double fuel) {
        if (this.getFuel() >= MAX_FUEL) {
            System.out.println("train already refueled.");
        }
        this.setFuel(this.getFuel() + fuel);
        if (this.getFuel() > MAX_FUEL) this.setFuel(MAX_FUEL);
        System.out.println("train refueled, current fuel is " + this.getFuel());
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

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    static class TrainBuilder implements VehicleBuilder {
        private Train train;

        public TrainBuilder() {
            this.train = Train.getTrain();
        }

        public TrainBuilder positionX(double positionX) {
            this.train.setPositionX(positionX);
            return this;
        }

        public TrainBuilder positionY(double positionY) {
            this.train.setPositionY(positionY);
            return this;
        }

        public TrainBuilder fuel(double fuel) {
            this.train.setFuel(fuel);
            return this;
        }

        public TrainBuilder engineStatus(Status engineStatus) {
            this.train.setEngineStatus(engineStatus);
            return this;
        }

        public TrainBuilder retired(boolean retired) {
            this.train.setRetired(retired);
            return this;
        }

        @Override
        public Vehicle build() {
            return this.train;
        }
    }
}
