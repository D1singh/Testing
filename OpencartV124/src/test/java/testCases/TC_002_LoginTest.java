package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test
	public void verify_login() {
		
		logger.info("....Starting TC_002_LoginTest....");
		
		
		try {
			// Home Page
			HomePage hp= new HomePage(driver);
			
			hp.clickAccount();
			hp.clickLogin();
			
			
			//Login Page
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Email(p.getProperty("email"));
			lp.Password(p.getProperty("password"));
			lp.LoginBTN();
			
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExist();
			Assert.assertEquals(targetPage, true,"Login Failed");
			
			logger.info("....Finished TC_002_LoginTest....");
			
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		
	}

}
