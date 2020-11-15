package jkjtf;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class LinksTestStandAlone {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//java//resources//drivers//geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SoftAssert sa = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for(WebElement link:links) {
			
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			sa.assertTrue(responseCode < 400, "Failed Link is:"+" "+link.getText()+" "+"Response code is:"+" "+responseCode);
			
			
		}
		sa.assertAll();
		
		driver.close();
		driver.quit();
		
	}

}
