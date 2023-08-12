package com.neshan.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID ID;
    private double totalCost;
    private final List<orderItem> orderItems;

    public Order() {
        this.ID = UUID.randomUUID();
        orderItems = new ArrayList<>();
    }

    public UUID getID() {
        return ID;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    private static class orderItem {
        private int count;
        private Product product;

        public orderItem(int count, Product product) {
            this.count = count;
            this.product = product;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

    public void addOrderItem(int count, Product product) {
        orderItem newItem = new orderItem(count, product);
        orderItems.add(newItem);
        updateTotalCost();
    }

    private void updateTotalCost() {
        totalCost = orderItems.stream()
                .mapToDouble(item -> item.getCount() * item.getProduct().getPrice())
                .sum();
        this.setTotalCost(totalCost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", totalCost=" + totalCost +
                ", orderItems=" + orderItems +
                '}';
    }
}
