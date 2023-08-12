package com.neshan.hotel;

import com.neshan.place.Place;
import com.neshan.location.Address;
import com.neshan.location.Coordinate;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Hotel extends Place {

    private int star;
    private List<Meal> meals;
    private List<String> features;
    private Date entrance;
    private Date leaving;
    private List<Room> rooms;

    public Hotel(
            String name,
            Address address,
            Coordinate coordinates,
            String description,
            int star,
            List<Meal> meals,
            List<String> features,
            Date entrance,
            Date leaving,
            List<Room> rooms) {
        super(name, address, coordinates, description);
        this.star = star;
        this.meals = meals;
        this.features = features;
        this.entrance = entrance;
        this.leaving = leaving;
        this.rooms = rooms;
    }

    public Hotel(
            String name,
            int star,
            List<Meal> meals,
            List<String> features,
            Date entrance,
            Date leaving,
            List<Room> rooms) {
        super(name);
        this.star = star;
        this.meals = meals;
        this.features = features;
        this.entrance = entrance;
        this.leaving = leaving;
        this.rooms = rooms;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {

        if (star >= 1 && star <= 5)
            this.star = star;
        else
            throw new IllegalArgumentException("Star rating must be between 1 and 5");
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Date getEntrance() {
        return entrance;
    }

    public void setEntrance(Date entrance) {
        this.entrance = entrance;
    }

    public Date getLeaving() {
        return leaving;
    }

    public void setLeaving(Date leaving) {
        this.leaving = leaving;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getUnreservedRooms() {

        var unreservedRooms = new LinkedList<Room>();
        for (Room room : this.rooms) {
            if (!room.isReserved())
                unreservedRooms.add(room);
        }

        return unreservedRooms;
    }

    public void checkIn(int roomNumber) {

        Room selectedRoom = findRoomByNumber(roomNumber);

        if (selectedRoom != null) {
            if (!selectedRoom.isReserved()) {
                selectedRoom.setReserved(true);
                System.out.printf("Room number %d has been successfully reserved.%n", roomNumber);
            } else {
                throw new IllegalArgumentException("The room is already reserved.");
            }
        } else {
            throw new IllegalArgumentException("Room not found with the given room number.");
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : this.getRooms()) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null; // Room not found
    }
}
