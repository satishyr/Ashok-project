import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.app.Welcome;

public class WelcomeTest {
	@Test
	public void TestGetWelcomeMsg() {
		Welcome welcome=new Welcome();
		String actualmsg=welcome.getWelcomeMsg();
		String exeptedmsg="welcome to JAVA";
		assertEquals(exeptedmsg, actualmsg);
	}

}
