package testNgPack;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
//import org.testng.Assert;
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
import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;

import browserSetUp.Base;
import page.ForgotPasswordPage;
import page.Loginpage;
import utils.Utility;

public class TestNg extends Base {
	
	WebDriver driver;
	Loginpage loginpage;
	ForgotPasswordPage forgotPasswordPage;
	String testID;
	
    @Parameters("browser")
	
/*	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite TestNg ");
	}*/
	
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println("Before Test TestNg ");
		if(browserName.equals("Chrome"))
		{
			 driver=OpenChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
			 driver=OpenEdgeBrowser();
			 
		}
		if(browserName.equals("safari"))
		{
			  driver=OpenChromeBrowser();
			 driver=OpenChromeBrowser();
			 driver=OpenChromeBrowser();
			 driver=OpenChromeBrowser();
			 
	}
		/*if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\gopik\\Downloads\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		if(browserName.equals("Opera"))
		{
			System.setProperty("webdriver.opera.driver","C:\\Users\\gopik\\Downloads\\selenium\\operadriver_win32\\operadriver_win32\\operadriver.exe");
			 driver=new OperaDriver();
		}*/
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void CreatePOMobject() {
		System.out.println("Before Class");
		  loginpage=new Loginpage(driver);
		  forgotPasswordPage=new ForgotPasswordPage(driver);
		 
		//  String data=Utility.getExcelData("Sheet1", 0, 0);
		 // loginpage.Sendusername(data);
	//	  loginpage.Sendusername(Utility.getExcelData("TestData", 1, 1));

		 // data=Utility.getExcelData("Sheet1", 1, 0);
		 // loginpage.SendPassword(data);
	//	  loginpage.SendPassword(Utility.getExcelData("TestData", 2, 1));
		//  loginpage.ClickonLoginButtton();
	}
	@BeforeMethod
	public void BrowserOpen() {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com");
	     loginpage.ClickForgotPassword();
	}
	
	@Test
	public void VerifyMassageonForgotPasswordPage() {
		testID="T100";
		System.out.println("Test 1");
	//	ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver);
		String actualMsg=forgotPasswordPage.getTextMassage();
		String expectedMsg="Please enter your email address or mobile number to search for your account.";
	    if(actualMsg.equals(expectedMsg))
	    {
	    	System.out.println(" Test 1 Passed");
	    }
	    else
	    {
	    	System.out.println(" Test 1 Failed");
	    }	
	}
	@Test
	public void VerifyCancleButtonOnForgotPasswordPage() {
		testID="T200";
        System.out.println("Test 2");
	//	ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver);
		forgotPasswordPage.ClickCancleButton();
		String expectedURL="https://www.facebook.com/login.php";
		String expectedTitle="Log in to Facebook";
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
	//	Assert.assertEquals(actualURL, expectedURL);
	//	Assert.assertEquals(actualTitle, expectedTitle);
//	SoftAssert soft=new SoftAssert();
//	soft.assertEquals(actualURL, expectedURL);
//	soft.assertEquals(actualTitle, expectedTitle);
//		soft.assertAll();
		if(expectedURL.equals(actualURL)&&expectedTitle.equals(actualTitle))
		{
			System.out.println(" Test 2 Passed");
		}
		else
		{
			System.out.println(" Test 2 Failed");
		}	
		
		
	}
	/*
	@Test
	public void VerifyClickSerachButton() {
		testID="T300";
		System.out.println("Test 3");
	//	String data=Utility.getExcelData("TestData", 0, 0);
	//	 forgotPasswordPage.SendEmailOrPhoneNumber(data);
	    forgotPasswordPage.SendEmailOrPhoneNumber("gopi123@yahoo.com");
	//	forgotPasswordPage.ClickCloseButton();
		forgotPasswordPage.ClickSerachButton();
	    forgotPasswordPage.ClickCloseButton();
	  //  forgotPasswordPage.ClickCancleButton();
		String expectederrorTitle="No search results";
		String expectederrormassage="Your search did not return any results. Please try again with other information.";
		String actualerrorTitle=forgotPasswordPage.geterrorTitle();
		String actualerrormassage=forgotPasswordPage.geterrorMsg();
		if(expectederrorTitle.equals(actualerrorTitle)&&expectederrormassage.equals(actualerrormassage))
		{
			System.out.println("Test 3 Passed");
		}
		else
		{
			System.out.println(" Test 3 Failed");
		}
	//	Assert.assertEquals(actualerrorTitle, expectederrorTitle);
	//	Assert.assertEquals(actualerrormassage, expectederrormassage);
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualerrorTitle, expectederrorTitle);
		soft.assertEquals(actualerrormassage, expectederrormassage);
		
	}
	*/

	
	@AfterMethod
	public void LogoutFromApplication(ITestResult result) {
		System.out.println("After Method");
		if(ITestResult.FAILURE==result.getStatus()) {
			
			Utility.CaptureScreenshot(driver, testID);
		}
		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		 loginpage=null;
		 forgotPasswordPage=null;

	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test TestNg ");
		driver.quit();
		driver=null;
		System.gc();//garbeg collection
	}

/*	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite TestNg ");
	}*/
	
	

}
