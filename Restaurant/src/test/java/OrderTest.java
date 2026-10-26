import org.example.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private static final double D = 0.0001;

    private OrderMaker sampleOrder() {
        OrderMaker o = new OrderMaker();
        o.addItem(new Ketchup(new Onions(new Cheese(new Burger())))); // 7.49
        o.addItem(new Ketchup(new Fries()));                          // 3.24
        o.addItem(new Bacon(new Ketchup(new Onions(new HotDog()))));  // 5.99
        return o;
    }

    @Test
    void emptyOrderTotalIsZero() {
        assertEquals(0.0, new OrderMaker().calculateTotal(), D);
        assertTrue(new OrderMaker().getItems().isEmpty());
    }

    @Test
    void totalSumsItemsAndToppings() {
        assertEquals(16.72, sampleOrder().calculateTotal(), D);
    }

    @Test
    void addItemStoresItemsInOrder() {
        OrderMaker o = new OrderMaker();
        FoodItem a = new Burger();
        FoodItem b = new Fries();
        o.addItem(a);
        o.addItem(b);
        assertEquals(2, o.getItems().size());
        assertSame(a, o.getItems().get(0));
        assertSame(b, o.getItems().get(1));
    }

    @Test
    void addItemRejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> new OrderMaker().addItem(null));
    }

    @Test
    void getItemsIsUnmodifiable() {
        OrderMaker o = sampleOrder();
        assertThrows(UnsupportedOperationException.class, () -> o.getItems().add(new Burger()));
    }

    @Test
    void totalWithLoyaltyDiscount() {
        OrderMaker o = sampleOrder();
        assertEquals(16.72, o.calculateTotal(new LoyaltyStatus(LoyaltyStatus.Tier.NONE)), D);
        assertEquals(15.88, o.calculateTotal(new LoyaltyStatus(LoyaltyStatus.Tier.SILVER)), D);
        assertEquals(15.05, o.calculateTotal(new LoyaltyStatus(LoyaltyStatus.Tier.GOLD)), D);
        assertEquals(14.21, o.calculateTotal(new LoyaltyStatus(LoyaltyStatus.Tier.PLATINUM)), D);
    }

    @Test
    void printReceiptShowsItemsAndTotals() {
        PrintStream original = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf));
        try {
            sampleOrder().printReceipt(new LoyaltyStatus(LoyaltyStatus.Tier.GOLD));
        } finally {
            System.setOut(original);
        }
        String out = buf.toString();
        assertTrue(out.contains("Burger, Cheese, Onions, Ketchup"));
        assertTrue(out.contains("Subtotal"));
        assertTrue(out.contains("$16.72"));
        assertTrue(out.contains("GOLD (10% off)"));
        assertTrue(out.contains("$15.05"));
    }
}
