package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	By signin =By.xpath("//a[contains(@href,'sign_in')]");
	By title =By.xpath("//section[@id=\"content\"]//div[@class=\"text-center\"]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}

	public WebElement getLogin() {
		
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
	}
}
