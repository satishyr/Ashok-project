import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.app.DateUtils;

public class DateUtilsTest {
	@Test
	public void TestGetInstance(){
		
		DateUtils instance1=DateUtils.getInstance();
		DateUtils instance2=DateUtils.getInstance();
		
		assertEquals(instance1, instance2);
		
	}

}
