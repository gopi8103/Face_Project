package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//variable declaration
	@FindBy(xpath="//input[@id='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgotpassword;
	
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createnewacc;
	
	@FindBy(xpath="//a[text()='Sign up for Facebook']")
	private WebElement signUpforFacebook;
	
	// variable initialization
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void Sendusername(String user) {
		username.sendKeys(user);
	}
	public void SendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void ClickonLoginButtton() {
		loginbutton.click();
	}
	public void ClickForgotPassword() {
		forgotpassword.click();
	}
	public void ClickCreateNewAcc() {
		createnewacc.click();
	}
	public void ClicksignUpforFacebook() {
		signUpforFacebook.click();
	}
	public void LoginToApplication() {
		username.sendKeys("gopi@123.com");
		password.sendKeys("123456789");
		forgotpassword.click();

	}
	
	
	
	
	
	
	
}
