package org.example;

public class LoyaltyStatus {
    public enum Tier {
        NONE(0.00), SILVER(0.05), GOLD(0.10), PLATINUM(0.15);

        private final double discountRate;

        Tier(double discountRate) {
            this.discountRate = discountRate;
        }

        public double getDiscountRate() {
            return discountRate;
        }
    }

    private final Tier customerTier;

    public LoyaltyStatus(Tier tier) {
        if (tier == null){
            throw new IllegalArgumentException("Tier must not be null");
        }
        customerTier = tier;
    }

    public Tier getTier() {
        return customerTier;
    }

    public double getDiscountRate() {
        return customerTier.getDiscountRate();
    }

    /** Returns the total after the loyalty discount, rounded to cents. */
    public double applyDiscount(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("Total must not be negative");
        }
        return Math.round(total * (1 - customerTier.getDiscountRate()) * 100.0) / 100.0;
    }
}
