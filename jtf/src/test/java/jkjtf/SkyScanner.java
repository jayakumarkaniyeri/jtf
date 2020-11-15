package jkjtf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.POM_LandingPage;
import pageObjects.POM_SSHomePage;
import resources.Base;

public class SkyScanner extends Base{
	
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url2"));
	}


	@Test
	public void searchFlight() {

		POM_SSHomePage pomhp = new POM_SSHomePage(driver);
		log.info("Search test starts now");
		
		
		//driver.findElement(By.xpath("//button[@text='OK']")).click();
//		Set<String> openWindows = driver.getWindowHandles();
//		Iterator<String> itr = openWindows.iterator();			
//		String parentid = itr.next();
//		String childid = itr.next();
//		driver.switchTo().window(childid);
//		driver.findElement(By.xpath("//button[@text='OK']")).click();
		
//		driver.switchTo().window(parentid);
		pomhp.travelDir().click();
		pomhp.origin().sendKeys("LHR");
		pomhp.startPoint().click();
		pomhp.destination().sendKeys("COK");
		pomhp.reachingPoint().click();
		pomhp.departDate().sendKeys("16/11/2020");
		pomhp.returnDate().sendKeys("22/11/2020");		
		pomhp.submit().click();
		log.info("search clicked");
		
		
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();

	}

}
