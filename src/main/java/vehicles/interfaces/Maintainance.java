package vehicles.interfaces;

/**
 * This interface will define the concept of maintenance which will take place in different ways for
 * different kinds of vehicles
 */
public interface Maintainance {
    /**
     * Used to refuel a vehicle
     * @param fuel amount of fuel
     * @return returns the object itself, making method chaining implementation possible
     * @throws ArithmeticException Throws an exception if the number of fuel is not a valid number
     */
    Maintainance refuel(double fuel) throws ArithmeticException;

    /**
     * Repairs the vehicle
     * @return returns the object itself, making method chaining implementation possible
     */
    Maintainance repair();

    /**
     * Mark the vehicle as retired which will tell others remove all references from the car object
     * and let the garbage collector to just dispose of it
     */
    void retire();
}
