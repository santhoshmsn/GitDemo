package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateJavaTest extends base{
	
	public WebDriver driver;
	@BeforeTest
	public void intialize() throws IOException{
		driver = intializeDemo();
		driver.get(prop.getProperty("url"));
		
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		LandingPage lnd =new LandingPage(driver);
		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		Thread.sleep(2000);
		System.out.println(lnd.getTitle().getText());
		
		Assert.assertEquals(lnd.getTitle().getText(), "FEATURED COURSES");
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
