package browserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	

	public static WebDriver OpenChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\browserFile\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.facebook.com");

		return driver;
	}
    public static WebDriver OpenEdgeBrowser() {
		
    	System.setProperty("webdriver.edge.driver","src\\test\\resources\\browserFile\\msedgedriver.exe");
    	WebDriver driver=new EdgeDriver();
	//	driver.get("https://www.facebook.com");

		return driver;
	}
	
	

}
