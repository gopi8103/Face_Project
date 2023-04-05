package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPopUP {
	
	//variable declearation
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@aria-label='Surname']")
	private WebElement Surname;
	
	@FindBy(xpath="//input[@aria-label='Mobile number or email address']")
	private WebElement EmailOrPhone;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement Password;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;
	
//	@FindBy(xpath="//input[@id='u_d_6_uj']")
//	private WebElement custombutton;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement maleradiobutton;
	
	@FindBy(xpath="(//button[text()='Sign Up'])[1]")
	private WebElement signup;
	
	@FindBy(xpath="//img[@class='_8idr img']")
	private WebElement goToHomePage;
	
	WebDriver driver;
	
	// variable initialization
	public SignUpPopUP(WebDriver driver) {
		PageFactory.initElements(driver,this);	
		this.driver=driver;
	}
	
	//variable use
	public void SendFirstName(String name) {
		FirstName.sendKeys(name);
	}
	public void SendSurname(String surname ) {
		Surname.sendKeys(surname);
	}
	public void SendEmailOrPhone(String email) {
		EmailOrPhone.sendKeys(email);
	}
	public void SendPassword(String pass) {
		Password.sendKeys(pass);
	}
	public void Selectday() {
		//day.click();
	    Select select=new Select(day);
	    select.selectByIndex(14);
	}
	public void SelectMonth() {
	    Select select=new Select(month);
	    select.selectByVisibleText("Feb");
	}
	public void Selectyear() {
	    Select select=new Select(year);
	    select.selectByVisibleText("2023");
	}
//	public void Clickcustombutton() {
//		Actions action=new Actions(driver);
//		action.moveToElement(custombutton).click().build().perform();
//	}
	public void Clickmaleradiobutton() {
		boolean result=maleradiobutton.isSelected();
		if(result==false)
		{
			System.out.println("Male Radio Button not Selected");
		}
		else
		{
			System.out.println("Male Radio Button Selected");
		}	
		maleradiobutton.click();
		if(result=true) {
			System.out.println("clicking radio button selected");
		}
		else
		{
			System.out.println(" clicking radio button not selected");
		}	
	} 
	public void Clicksignup() {
		signup.click();
		boolean result=signup.isDisplayed();
		if(result==true)
		{
			System.out.println("entre details sign up button display");
		}
		else
		{
			System.out.println(" entre details sign button not display");
		}
	}
	public void ClickgoToHomePage() {
		goToHomePage.click();
	}	
	
	
	
	
	
	
	
	
	
	
	
}
