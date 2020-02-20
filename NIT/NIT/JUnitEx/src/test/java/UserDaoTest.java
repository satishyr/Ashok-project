import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.app.UserDao;



public class UserDaoTest {
	/*
	private static UserDao dao=null;
	
	public static void BeforeClass() {
		dao=new UserDao();
	}
	*/
	
	
	@Test
	public void TestFindUnameById() {
		UserDao dao=new UserDao();
		String name=dao.getUserById(101);
		assertNotNull(name);
	}
	
	//If A method need to ignore then use @Ignore in place of test
	
	@Test(timeout=3000)
	public void TestFindEmailById1() {
		
		UserDao dao=new UserDao();
		String email=dao.getUserEmailById(101);
		assertNotNull(email);
	}
	
	@Test
	public void TestFindEmailById2() {
		
		UserDao dao=new UserDao();
		String email=dao.getUserEmailById(30);
		assertNull(email);
	}
	
	}
