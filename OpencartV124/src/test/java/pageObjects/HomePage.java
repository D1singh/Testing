package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement accountLink;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Registor;
	
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement LgoinAccount;
	
	public void clickAccount() {
		accountLink.click();
	}
	public void clickRegistor() {
	Registor.click();	
	}
	
	public void clickLogin() {
		LgoinAccount.click();
	}

}
