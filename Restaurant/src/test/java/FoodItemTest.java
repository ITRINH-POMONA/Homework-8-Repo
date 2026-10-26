import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodItemTest {
    FoodItem hotDog = new HotDog();
    FoodItem burger = new Burger();
    FoodItem fries = new Fries();
    @Test
    public void verifyBaseFoodItems(){
        assertEquals("Hot Dog", hotDog.getDescription());
        assertEquals(3.99, hotDog.getCost());
        assertEquals("Burger", burger.getDescription());
        assertEquals(5.99, burger.getCost());
        assertEquals("Fries", fries.getDescription());
        assertEquals(2.99, fries.getCost());
    }
}
