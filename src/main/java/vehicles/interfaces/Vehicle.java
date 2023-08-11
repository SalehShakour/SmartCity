package vehicles.interfaces;

public interface Vehicle {
    static VehicleBuilder builder() {
        return null;
    }

    void move(double x, double y);

    void horn(short time);

    void refuel(double fuel);

    interface VehicleBuilder {
        Vehicle build();
    }
}
