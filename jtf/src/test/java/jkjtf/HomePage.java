package jkjtf;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.getUsername().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.clickSubmit().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][1];
		
		data[0][0] = "jay@gmail.com";
		data[0][1] = "12345";
		
		//data[1][0] = "kumar@gmail.com";
		//data[1][1] = "67890";
		
		return data;
	}

}
