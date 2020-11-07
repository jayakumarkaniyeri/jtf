package jkjtf;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.POM_LandingPage;
import resources.Base;

public class ValidateNavBar extends Base{
	
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}


	@Test
	public void navigationBar() throws IOException {

		POM_LandingPage lp = new POM_LandingPage(driver);
		Assert.assertFalse(lp.getNavigationBar().isDisplayed());
		//Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed");
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();

	}

}
