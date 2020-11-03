package jkjtf;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.POM_LandingPage;
import resources.Base;

public class ValidateNavBar extends Base{

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}


	@Test
	public void navigationBar() throws IOException {

		POM_LandingPage lp = new POM_LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();

	}

}
