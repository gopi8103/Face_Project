package TestPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.SignUpPopUP;
import page.ForgotPasswordPage;
import page.Loginpage;

public class TestClass {
	
	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver","C:\\Users\\gopik\\Downloads\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		
        
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);  //until 3.141.59 version	
		
		driver.get("https://www.facebook.com");
		
		Loginpage loginpage=new Loginpage(driver);
		
		loginpage.Sendusername("gopinath@123");
		loginpage.SendPassword("123465");
		loginpage.ClickForgotPassword();
		
		
		ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver);
		forgotPasswordPage.ClickCancleButton();
		
		SignUpPopUP signUpPopUP=new SignUpPopUP(driver);
		signUpPopUP.SendFirstName("gopi");
		signUpPopUP.SendSurname("kahandal");
		signUpPopUP.SendEmailOrPhone("gopinath@123");
		signUpPopUP.SendPassword("12345679");
		signUpPopUP.Selectday();
		signUpPopUP.SelectMonth();
		signUpPopUP.Selectyear();
		signUpPopUP.Clickmaleradiobutton();
		signUpPopUP.Clicksignup();
		
		
		
		
	}

}
