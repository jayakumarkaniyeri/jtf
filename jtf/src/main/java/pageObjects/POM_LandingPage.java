package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_LandingPage {
	
	public WebDriver driver;
	
	
	public POM_LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	By signin = By.cssSelector("a[href*='sign_in']");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right li a");
	
	

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getNavigationBar() {
		return  driver.findElement(navBar);
	}
			
}
