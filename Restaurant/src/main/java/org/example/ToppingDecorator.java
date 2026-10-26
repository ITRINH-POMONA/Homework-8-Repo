package org.example;

public abstract class ToppingDecorator implements FoodItem{
    protected final FoodItem food;

    protected ToppingDecorator(FoodItem food){
        if (food == null){
            throw new IllegalArgumentException("Food must not be null");
        }
        this.food = food;
    }

    protected abstract String getToppingName();

    protected abstract double getToppingCost();

    @Override
    public String getDescription() {
        return food.getDescription() + ", " + getToppingName();
    }

    @Override
    public double getCost() {
        return food.getCost() + getToppingCost();
    }
}
