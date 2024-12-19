package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_First_name;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_Last_name;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_phone_number;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confrm_password;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement txt_checkBox;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirm;

	public void FirstName(String Fname) {
		txt_First_name.sendKeys(Fname);
	}

	public void LastName(String Lname) {
		txt_Last_name.sendKeys(Lname);
	}

	public void Email(String email) {
		txt_email.sendKeys(email);
	}

	public void PhoneNumber(String Pnumber) {
		txt_phone_number.sendKeys(Pnumber);
	}

	public void Password(String pwd) {
		txt_password.sendKeys(pwd);
	}

	public void ConfrmPassword(String Cpwd) {
		txt_confrm_password.sendKeys(Cpwd);
	}

	public void CheckBox() {
		txt_checkBox.click();
	}

	public void BtnContinue() {
		btnContinue.click();
		
		//btnContinue.sendKeys(Keys.RETURN);
	}

	public String AccountConfirmation() {
		try {
			return (msgconfirm.getText());
		} catch (Exception e) {
			return e.getMessage();
		}

	}
}