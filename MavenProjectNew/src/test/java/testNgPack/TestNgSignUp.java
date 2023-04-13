package testNgPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSetUp.Base;
import module.SignUpPopUP;
import page.Loginpage;
import utils.Utility;

public class TestNgSignUp extends Base{
	
	WebDriver driver;
	Loginpage loginpage;
	SignUpPopUP signUpPopUP;
	String testID;
	
	@Parameters("browser")
	
	/*@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite TestNgSignUp ");
	}
	*/
	
	
	@BeforeTest
		public void openBrowser(String browserName) {
			System.out.println("Before Test TestNgSignUp ");
			if(browserName.equals("Chrome"))
			{
				driver=OpenChromeBrowser();
			}
			if(browserName.equals("Edge"))
			{
				driver=OpenEdgeBrowser();
				 
			}
			if(browserName.equals("Opera"))
			{
				System.setProperty("webdriver.opera.driver","C:\\Users\\gopik\\Downloads\\selenium\\operadriver_win32\\operadriver_win32\\operadriver.exe");
				 driver=new OperaDriver();
			}
			
			if(browserName.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\gopik\\Downloads\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
				 driver=new FirefoxDriver();
			}
			if(browserName.equals("Opera"))
			{
				System.setProperty("webdriver.opera.driver","C:\\Users\\gopik\\Downloads\\selenium\\operadriver_win32\\operadriver_win32\\operadriver.exe");
				 driver=new OperaDriver();
			}
		//	driver.manage().window().maximize();
		//	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		}
	@BeforeClass
	public void CreatePOMObject046565() {
		System.out.println("Before Class");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\gopik\\Downloads\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		//driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    loginpage=new Loginpage(driver);
		signUpPopUP=new SignUpPopUP(driver);
		
		
		
	}
	@BeforeClass
	public void CreatePOMObject() {
		System.out.println("Before Class");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\gopik\\Downloads\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		//driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    loginpage=new Loginpage(driver);
		signUpPopUP=new SignUpPopUP(driver);
		
		
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com");
	//	Loginpage loginpage=new Loginpage(driver);
		loginpage.ClickCreateNewAcc();
    }
	@Test
	public void test1() {
		System.out.println("Test1");
		
		signUpPopUP.SendFirstName("gopi");
		signUpPopUP.SendSurname("kahandal");
        String data=Utility.getExcelData("TestData", 0, 0);
	    signUpPopUP.SendEmailOrPhone(data);
		//signUpPopUP.SendEmailOrPhone("gopinath@123");
		signUpPopUP.SendPassword("12345679");
		signUpPopUP.Selectday();
		signUpPopUP.SelectMonth();
		signUpPopUP.Selectyear();
		signUpPopUP.Clickmaleradiobutton();

		
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
		
		signUpPopUP.SendFirstName("gopi");
		signUpPopUP.SendSurname("kahandal");
		signUpPopUP.SendEmailOrPhone("gopinath123@");
		signUpPopUP.SendPassword("12345679");
		
		signUpPopUP.Selectday();
		signUpPopUP.SelectMonth();
		signUpPopUP.Selectyear();
		signUpPopUP.Clickmaleradiobutton();
		signUpPopUP.Clicksignup();
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("After Method");
	
		if(ITestResult.FAILURE==result.getStatus()) {
			
			Utility.CaptureScreenshot(driver, testID);
		}
		
		signUpPopUP.ClickgoToHomePage();
		
		
		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		loginpage=null;
		signUpPopUP=null;
		
	}
	@AfterTest
	public void ClosedBrowser() {
		System.out.println("After Test TestNgSignUp ");
		driver.quit();
		driver=null;
		System.gc(); //garbeg collection
	}

/*	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite TestNgSignUp ");
	}*/

}
