package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_LoginPage {
	
	public WebDriver driver;
	
	public POM_LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By btn_login = By.cssSelector("input[name='commit']");
	
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement clickSubmit() {
		return driver.findElement(btn_login);	
	}

}
