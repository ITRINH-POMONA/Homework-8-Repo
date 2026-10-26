package org.example;

public class Onions extends ToppingDecorator{
    public Onions(FoodItem item) {
        super(item);
    }

    @Override
    protected String getToppingName() {
        return "Onions";
    }

    @Override
    protected double getToppingCost() {
        return 0.50;
    }
}
