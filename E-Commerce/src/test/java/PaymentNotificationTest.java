import org.example.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentNotificationTest {
    private final NotificationChannel email = new EmailChannel();
    private final NotificationChannel sms = new SmsChannel();
    private final NotificationChannel push = new PushChannel();

    OnlinePaymentNotification emailOnline = new OnlinePaymentNotification(email, 59.99, "PayPal");

    @Test
    public void checkCorrectMessageOnline(){
        assertEquals("Your online payment of $59.99 via PayPal was successful. Thank you for your order!",
                emailOnline.buildMessage());
    }
    @Test
    public void checkCorrectPaymentMethodOnline(){
        assertEquals("PayPal", emailOnline.getPaymentMethod());
    }
    @Test
    public void checkCorrectAmountOnline(){
        assertEquals(59.99, emailOnline.getAmount(), 0.0001);
    }
    @Test
    public void checkChannelTypeOnline(){
        assertEquals("Email", emailOnline.getChannel().getChannelName());
    }
    @Test
    public void checkChannelMessage(){
        String fullMessage = "[Email to Gabe@CD.com] Your online payment of $59.99 via PayPal was successful. " +
                                "Thank you for your order!";
        String actualMessage = emailOnline.getChannel().send("Gabe@CD.com", emailOnline.buildMessage());
        assertEquals(fullMessage, actualMessage);
    }
}
