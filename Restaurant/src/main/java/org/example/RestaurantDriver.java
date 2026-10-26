package org.example;

public class RestaurantDriver {
    public static void main(String[] args){
        FoodItem burger = new Ketchup(new Onions(new Cheese(new Burger())));
        FoodItem fries = new Ketchup(new Fries());
        FoodItem hotDog = new Bacon(new Ketchup(new Onions(new HotDog())));

        System.out.println(burger.getDescription() + " -> $" + String.format("%.2f", burger.getCost()));
        System.out.println(fries.getDescription() + " -> $" + String.format("%.2f", fries.getCost()));
        System.out.println(hotDog.getDescription() + " -> $" + String.format("%.2f", hotDog.getCost()));
        System.out.println();

        OrderMaker newOrder = new OrderMaker();

        newOrder.addItem(burger);
        newOrder.addItem(fries);
        newOrder.addItem(hotDog);

        newOrder.printReceipt(new LoyaltyStatus(LoyaltyStatus.Tier.NONE));
        newOrder.printReceipt(new LoyaltyStatus(LoyaltyStatus.Tier.SILVER));
        newOrder.printReceipt(new LoyaltyStatus(LoyaltyStatus.Tier.GOLD));
        newOrder.printReceipt(new LoyaltyStatus(LoyaltyStatus.Tier.PLATINUM));
    }
}
