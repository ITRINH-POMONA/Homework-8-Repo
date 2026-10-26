package org.example;

public class Cheese extends ToppingDecorator{
    public Cheese(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Cheese";
    }

    @Override
    protected double getToppingCost() {
        return 0.75;
    }
}
