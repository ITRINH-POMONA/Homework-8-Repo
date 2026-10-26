import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoyaltyStatusTest {
    @ParameterizedTest
    @CsvSource({"NONE,0.00", "SILVER,0.05", "GOLD,0.10", "PLATINUM,0.15"})
    void tierDiscountCheck(LoyaltyStatus.Tier tier, double rate){
        assertEquals(rate, tier.getDiscountRate());
        assertEquals(rate, new LoyaltyStatus(tier).getDiscountRate());
    }

    @ParameterizedTest
    @CsvSource({"NONE,100.00,100.00", "SILVER,100.00,95.00", "GOLD,100.00,90.00", "PLATINUM,100.00,85.00",
            "GOLD,10.99,9.89", "SILVER,0.00,0.00"})
    void applyDiscountCheck(LoyaltyStatus.Tier tier, double total, double expected) {
        assertEquals(expected, new LoyaltyStatus(tier).applyDiscount(total));
    }
    @Test
    void getTierReturnsCorrect() {
        assertEquals(LoyaltyStatus.Tier.GOLD, new LoyaltyStatus(LoyaltyStatus.Tier.GOLD).getTier());
    }

    @Test
    void rejectsNullTierAndNegativeTotal() {
        assertThrows(IllegalArgumentException.class, () -> new LoyaltyStatus(null));
        assertThrows(IllegalArgumentException.class, () -> new LoyaltyStatus(LoyaltyStatus.Tier.GOLD).applyDiscount(-1));
    }
}
