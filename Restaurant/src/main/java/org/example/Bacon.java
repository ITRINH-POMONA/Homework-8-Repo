package org.example;

public class Bacon extends ToppingDecorator {
    public Bacon(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Bacon";
    }

    @Override
    protected double getToppingCost() {
        return 1.25;
    }
}
