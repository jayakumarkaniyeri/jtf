package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	By signin = By.cssSelector("a[href*='sign_in']");
	
	

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
			
}
