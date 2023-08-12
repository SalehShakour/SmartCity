package com.neshan.restaurant;

import java.util.List;

public class Menu {
    private String title;
    private List<Product> products;

    public Menu(String title, List<Product> products) {
        this.title = title;
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", products=" + products +
                '}';
    }
}
