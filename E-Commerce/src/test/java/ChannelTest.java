import org.example.EmailChannel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class ChannelTest {
    EmailChannel sampleEmail = new EmailChannel();
    @Test
    public void testEmailChannel(){
        String message = sampleEmail.send("A@D.com", "meow");
        String correctMessage = "[Email to A@D.com] meow";
        assertEquals(correctMessage, message);
    }

}
