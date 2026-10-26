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


}
