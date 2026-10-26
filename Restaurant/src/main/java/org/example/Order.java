package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<FoodItem> orderList = new ArrayList<>();

    public void addItem(FoodItem food){
        if (food == null){
            throw new IllegalArgumentException(("Food can not be null"));
        }
        orderList.add(food);
    }

    public List<FoodItem> getItems() {
        return Collections.unmodifiableList(orderList);
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : orderList) {
            total += item.getCost();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public double calculateTotal(LoyaltyStatus status) {
        return status.applyDiscount(calculateTotal());
    }

    public void printReceipt(LoyaltyStatus status) {
        System.out.println("----- Order Receipt -----");
        for (FoodItem item : orderList) {
            System.out.printf("%-35s $%.2f%n", item.getDescription(), item.getCost());
        }
        double subtotal = calculateTotal();
        System.out.printf("%-35s $%.2f%n", "Subtotal", subtotal);
        System.out.printf("%-35s %s (%.0f%% off)%n", "Loyalty", status.getTier(), status.getDiscountRate() * 100);
        System.out.printf("%-35s $%.2f%n", "TOTAL", status.applyDiscount(subtotal));
        System.out.println();
    }
}
