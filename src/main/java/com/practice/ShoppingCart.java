package com.practice;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }


    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }


}
