package org.example;

public class Ketchup extends ToppingDecorator{
    public Ketchup(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Ketchup";
    }

    @Override
    protected double getToppingCost() {
        return 0.25;
    }
}
