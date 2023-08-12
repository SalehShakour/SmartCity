package com.neshan.restaurant;

import com.neshan.location.Address;
import com.neshan.location.Coordinate;
import com.neshan.place.Place;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Place {

    private Menu menu;
    private int numSeats;
    private final List<Order> orders;

    public Restaurant(
            String name,
            Address address,
            Coordinate coordinates,
            String description,
            Menu menu,
            int numSeats) {
        super(name, address, coordinates, description);
        this.menu = menu;
        this.numSeats = numSeats;
        this.orders = new ArrayList<>();
    }

    public Restaurant(String name, Menu menu, int numSeats) {
        super(name);
        this.menu = menu;
        this.numSeats = numSeats;
        this.orders = new ArrayList<>();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public void createOrder(int count, Product product) {

        Order newOrder = new Order();
        newOrder.addOrderItem(count, product);
        System.out.println("Order was created successfully.");
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", numSeats=" + numSeats +
                ", orders=" + orders +
                '}';
    }
}
