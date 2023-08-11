package vehicles.interfaces;

/**
 * <h1>The Vehicle interface</h1>
 * The Vehicle interface is an abstraction for vehicle concept which will be used for having different types
 * of vehicles which share the common attributes and methods declared inside the interface body.
 * <p>
 *     This design is based on the "Builder" design pattern which eases the creation of objects.
 * </p>
 */
public interface Vehicle {
    static VehicleBuilder builder() {
        return null;
    }

    /**
     * This method is used to move the vehicle it's being called by to a specified destination.
     * @param x X of the destiantion point
     * @param y Y of the destination point
     */
    void move(double x, double y);

    /**
     * This method will make the vehicle horn for a specific amount of time
     * @param time The time to horn in seconds
     */
    void horn(short time);

    /**
     * This method will refuel the vehicle
     * @param fuel amount of fuel being passed for the process of refueling
     */
    void refuel(double fuel);

    interface VehicleBuilder {
        Vehicle build();
    }
}
