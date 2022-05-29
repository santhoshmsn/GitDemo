package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver intializeDemo() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\santh\\eclipse-workspace\\MajorProject\\src\\main\\java\\resources\\file.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\drivers\\\\chromedriver_win32\\\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\\\drivers\\\\geckodriver-v0.30.0-win64\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else {
			System.setProperty("webdriver.edge.driver", "C:\\\\drivers\\\\msedgedriver.exe");
			driver = new EdgeDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		return driver;
	}
	
}
