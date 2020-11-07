package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_ForgotPassword {
	
	public WebDriver driver;
	
	public POM_ForgotPassword(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By email_address = By.id("user_email");
	By btn_sndMeInstr = By.name("commit");
	
	
	public WebElement enterEmailAdd() {
		return driver.findElement(email_address);
	}
	
	public WebElement sendMeInstr() {
		return driver.findElement(btn_sndMeInstr);
		}
	


}
