package com.delivery.api_delivery.entities;

public class Food {
    private String name;
    private String description;
    private double price;

    public Food(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
