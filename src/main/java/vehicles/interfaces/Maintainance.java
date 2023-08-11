package vehicles.interfaces;

public interface Maintainance {
    Maintainance refuel(Vehicle vehicle, double fuel);
    Maintainance repair(Vehicle vehicle);
    Maintainance retire(Vehicle vehicle);
}
