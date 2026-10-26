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
    public void checkChannelMessageOnline(){
        String fullMessage = "[Email to Gabe@CD.com] Your online payment of $59.99 via PayPal was successful. " +
                                "Thank you for your order!";
        String actualMessage = emailOnline.getChannel().send("Gabe@CD.com", emailOnline.buildMessage());
        assertEquals(fullMessage, actualMessage);
    }

    CashOnDeliveryPayment smsCash = new CashOnDeliveryPayment(sms, 89.99);
    @Test
    public void checkCorrectMessageCash(){
        assertEquals("Your order is confirmed. Please have $89.99 in cash ready upon delivery.",
                smsCash.buildMessage());
    }
    @Test
    public void checkCorrectAmountCash(){
        assertEquals(89.99, smsCash.getAmount(), 0.0001);
    }
    @Test
    public void checkChannelTypeCash(){
        assertEquals("SMS", smsCash.getChannel().getChannelName());
    }
    @Test
    public void checkChannelMessageCash(){
        String fullMessage = "[SMS to 888-8888] Your order is confirmed. Please have $89.99 in " +
                                "cash ready upon delivery.";
        String actualMessage = smsCash.getChannel().send("888-8888", smsCash.buildMessage());
        assertEquals(fullMessage, actualMessage);
    }


}
