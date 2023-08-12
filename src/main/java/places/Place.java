package places;

import utils.Address;
import utils.Coordinate;

public abstract class Place {

    private String name;
    private Address address;
    private Coordinate coordinates;
    private String description;

    public Place(String name) {
        this.name = name;
    }

    public Place(String name, Address address, Coordinate coordinates, String description) {
        this.name = name;
        this.address = address;
        this.coordinates = coordinates;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
