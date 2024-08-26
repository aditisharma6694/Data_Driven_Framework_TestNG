package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	
	public Properties prop;
	
	public WebDriver openBrowser(String browserName) throws IOException {
		
		prop = new Properties();
		File file = new File("src\\test\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} /*
			 * else if(browserName.equalsIgnoreCase("firefox")) {
			 * 
			 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
			 * 
			 * }
			 */else if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}


}
