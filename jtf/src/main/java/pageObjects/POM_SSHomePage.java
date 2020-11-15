package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class POM_SSHomePage {
	
	WebDriver driver;
	
	public POM_SSHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@aria-label='Return']")
	WebElement rbtn_trvl;
	
	@FindBy(xpath = "//input[@id='fsc-origin-search']")
	WebElement fld_origin;
	
	@FindBy(xpath = "//span[text()=' Heathrow (LHR)']")
	WebElement origin;
	
	@FindBy(id = "fsc-destination-search")
	WebElement fld_destination;
	
	@FindBy(xpath = "//strong[text()='COK']")
	WebElement destination;
	
	@FindBy(id = "depart-fsc-datepicker-button'")
	WebElement dateDepart;
	
	@FindBy(id = "return-fsc-datepicker-button")
	WebElement dateReturn;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_submit;
	
	
	
	
	public WebElement travelDir() {
		return rbtn_trvl;
	}
	
	public WebElement origin() {
		return fld_origin;
	}
	
	public WebElement startPoint() {
		return origin;
	}
	
	public WebElement destination() {
		return fld_destination;
	}
	
	public WebElement reachingPoint() {
		return destination;
	}
	
	public WebElement departDate() {
		return dateDepart;
	}
	
	public WebElement returnDate() {
		return dateReturn;
	}
	
	public WebElement submit() {
		return btn_submit;
	}
	
}
