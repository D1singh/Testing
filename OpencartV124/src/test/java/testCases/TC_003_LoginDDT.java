package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // getting data provider from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("******* Starting TC_003_loginTDD Test ******");
		try {
			// Home Page
			HomePage hp = new HomePage(driver);

			hp.clickAccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);
			lp.Email(email);
			lp.Password(pwd);
			lp.LoginBTN();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExist();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					macc.Logout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.Logout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("******* Finsihed TC_003_loginTDD Test ******");

	}
}