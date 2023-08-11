package vehicles.interfaces;

public interface Maintainance {
    Maintainance refuel(double fuel) throws ArithmeticException;

    Maintainance repair();

    void retire();
}
