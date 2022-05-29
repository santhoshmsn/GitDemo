package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username =By.xpath("//input[@id=\"user_email\"]");
	By password =By.id("user_password");	
	By login =By.xpath("//input[@name=\"commit\"]");	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}

	public WebElement getUsername() {
		
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		
		return driver.findElement(password);
	}
	
	public WebElement loginBtn() {
		
		return driver.findElement(login);
	}

}
