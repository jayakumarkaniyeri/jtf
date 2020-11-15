package jkjtf;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.Base;

public class BrokenLinks extends Base{
	
	public WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url3"));
	}
	
	@Test
	public void LinkTests() throws MalformedURLException, IOException {
		
		log.info("Searching for all available links");
		SoftAssert sa = new SoftAssert();
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			
			sa.assertTrue(responseCode < 400, "Failed Link is:"+" "+link.getText()+" "+"Response code is:"+" "+responseCode);

			
			sa.assertAll();
			
		}
		 
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
