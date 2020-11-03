package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			//firefox code
		}
		
		else if(browserName.equals("IE")) {
			//IE Code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

}
