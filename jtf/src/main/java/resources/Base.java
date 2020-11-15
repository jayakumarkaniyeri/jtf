package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "//src//main//java//resources//data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//String browserName = System.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "//src//main//java//resources//drivers//chromedriver");
			//System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			
			
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "//src//main//java//resources//drivers//geckodriver");
			driver = new FirefoxDriver();
		
		}
		
		else if(browserName.equals("safari")) {
			System.setProperty("webdriver.safari.driver", projectPath + "//src//main//java//resources//drivers//safaridriver");
			driver = new SafariDriver();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//"+testCaseName+".png";
		try {
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile;
		
	}

}
