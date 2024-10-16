package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_LoginTest {
	
	@DataProvider(name = "loginData")
	public Object[][] provideLoginData(){
		
		return new Object[][] {
			{"user1","password1"},
			{"user2","password2"},
			{"user3","password3"}
			
		};
		
	}
	
	@Test(dataProvider = "loginData")
	public void testLogin(String username, String password) {
		
		System.out.println("Username: "+username +"  Password: "+password);
		
	}

}
