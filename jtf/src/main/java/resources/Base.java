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
	
	public WebDriver initializeDriver() throws IOException {
		
		//String projectPath = System.getProperty("user.dir");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Aiswa\\eclipse-workspace\\jtf\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aiswa\\Downloads\\chromedriver.exe");
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
