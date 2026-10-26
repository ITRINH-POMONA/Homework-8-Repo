import org.example.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ChannelTest {
    EmailChannel sampleEmail = new EmailChannel();
    SmsChannel sampleSMS = new SmsChannel();
    PushChannel samplePush = new PushChannel();

    @Test
    public void testEmailChannel(){
        String message = sampleEmail.send("A@D.com", "meow");
        String correctMessage = "[Email to A@D.com] meow";
        assertEquals(correctMessage, message);
        assertEquals("Email", sampleEmail.getChannelName());
    }

    @Test
    public void testSmsChannel(){
        String message = sampleSMS.send("(714) 888-8888", "meow");
        String correctMessage = "[SMS to (714) 888-8888] meow";
        assertEquals(correctMessage, message);
        assertEquals("SMS", sampleSMS.getChannelName());
    }

    @Test
    public void testPushChannel(){
        String message = samplePush.send("cheese", "meow");
        String correctMessage = "[Push to cheese] meow";
        assertEquals(correctMessage, message);
        assertEquals("Push", samplePush.getChannelName());
    }
}
