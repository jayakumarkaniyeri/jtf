package jkjtf;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.POM_ForgotPassword;
import pageObjects.POM_LandingPage;
import pageObjects.POM_LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initiated");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver.get(prop.getProperty("url"));
		POM_LandingPage lp = new POM_LandingPage(driver);
		lp.getLogin().click();
		
		POM_LoginPage login = new POM_LoginPage(driver);
		login.getUsername().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.clickSubmit().click();
		log.info("Submit button clicked");
		
		POM_ForgotPassword fp = login.forgotPassword();
		fp.enterEmailAdd().sendKeys("xyz");
		fp.sendMeInstr().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "jay@gmail.com";
		data[0][1] = "12345";
		
		data[1][0] = "kumar@gmail.com";
		data[1][1] = "12345";
		
		return data;
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();

	}


}
