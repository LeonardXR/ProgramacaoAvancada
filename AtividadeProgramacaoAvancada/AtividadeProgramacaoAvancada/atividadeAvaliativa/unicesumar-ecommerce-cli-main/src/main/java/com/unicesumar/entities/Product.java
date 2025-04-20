package com.unicesumar.entities;

import java.util.UUID;

public class Product extends Entity {
    private final String name;
    private final double price;

    public Product(UUID uuid, String name, double price) {
        super(uuid);
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("%s - %s", this.name, this.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return this.getUuid().equals(product.getUuid());
    }

    @Override
    public int hashCode() {
        return this.getUuid().hashCode();
    }
}
