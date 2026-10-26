import org.example.EmailChannel;
import static org.junit.jupiter.api.Assertions.*;

import org.example.SmsChannel;
import org.junit.jupiter.api.Test;



public class ChannelTest {
    EmailChannel sampleEmail = new EmailChannel();
    SmsChannel sampleSMS = new SmsChannel();

    @Test
    public void testEmailChannel(){
        String message = sampleEmail.send("A@D.com", "meow");
        String correctMessage = "[Email to A@D.com] meow";
        assertEquals(correctMessage, message);
    }

    @Test
    public void testSmsChannel(){
        String message = sampleSMS.send("(714) 888-8888", "meow");
        String correctMessage = "[SMS to (714) 888-8888] meow";
        assertEquals(correctMessage, message);
    }
}
