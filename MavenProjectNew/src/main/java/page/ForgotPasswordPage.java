package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	//variable declaration
	@FindBy(xpath="//table//div")
	private WebElement textmassage;
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	private WebElement emailOrPhoneNumber;
	
	@FindBy(xpath="//a[text()='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement canclebutton;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement serachbutton;
	
	@FindBy(xpath="//div[text()='No search results']")
	private WebElement noSucherrorText;
	
	@FindBy(xpath="//div[@class='_9o4h']")
	private WebElement errorMsgserachbutton;
	
	//variable initilization
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//variable use
	public String getTextMassage() {
		return textmassage.getText();
	  // String text=textmassage.getText();
	//return text;	
	}
	public void SendEmailOrPhoneNumber(String name) {
		emailOrPhoneNumber.sendKeys(name);
	}
	public void ClickCloseButton() {
		closeButton.click();
	}
	public void ClickCancleButton() {
		canclebutton.click();
	}
	public void ClickSerachButton() {
		serachbutton.click();
	}
	public String geterrorTitle() {
		return noSucherrorText.getText();
	}
	public String geterrorMsg() {
		return errorMsgserachbutton.getText();
	}
	
	
	
	
	
	
	
	
	

}
