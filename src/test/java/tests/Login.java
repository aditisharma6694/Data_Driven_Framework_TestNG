package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver;
	
	@Test(dataProvider = "dataProvider")
	public void testLogin(String email, String password) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);	
		driver.findElement(By.id("input-password")).sendKeys(password);	
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());	
	}
	
	@DataProvider
	public Object[][] dataProvider() {
		Object[][] data = {{"amotooricap9@gmail.com","12345"},
						{"amotooricap1@gmail.com","12345"},
						{"amotooricap3@gmail.com","12345"}};
		return data;
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
