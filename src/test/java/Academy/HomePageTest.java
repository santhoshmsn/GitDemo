package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void intialize() throws IOException {
		driver = intializeDemo();	
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username,String password,String text) throws IOException, InterruptedException {
		
		//driver = intializeDemo();
		driver.get(prop.getProperty("url"));
		
		LoginPage lp =new LoginPage(driver); 
		LandingPage lnd =new LandingPage(driver);
		
		if(driver.findElements(By.xpath("//button[text()='NO THANKS']")).size()>0) {
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();	
			Thread.sleep(1000);
			lnd.getLogin().click();
			
		}else{
			Thread.sleep(1000);
			lnd.getLogin().click();
		}
		Thread.sleep(1000);
		//lnd.getLogin().click();
		//lp =new LoginPage(driver);
		lp.getUsername().sendKeys(username);		
		lp.getPassword().sendKeys(password);		
		System.out.println(text);
		lp.loginBtn().click();
		Thread.sleep(2000);
		
			
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][3];
		
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="12345";
		data[0][2]="Restricted user";
		
		data[1][0]="nonrestricteduser@gmail.com";
		data[1][1]="56789";
		data[1][2]="non Restricted user";
		
		return data;
		
		
	}
	


}
