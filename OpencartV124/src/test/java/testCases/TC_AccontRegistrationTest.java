package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_AccontRegistrationTest extends BaseClass {

	@Test
	public void verfiy_account_registation() {
		
		logger.info("*** Starting TC_AccountRegistrationTest ****");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAccount();
		logger.info("*** click on MyAccount Link ****");
		hp.clickRegistor();
		
		logger.info("*** click on Register Link ****");
		
		AccountRegisterPage regpage= new AccountRegisterPage(driver);
		logger.info("*** Providing customer Details....... ****");
		
		regpage.FirstName(randomString().toUpperCase());
		regpage.LastName(randomString().toUpperCase());
		regpage.Email(randomString()+"@gmail.com");
		regpage.PhoneNumber(randomNumber());
		
		
		String password=randomAlphaNumeric();

		regpage.Password(password);
		regpage.ConfrmPassword(password);
		regpage.CheckBox();
		regpage.BtnContinue();
		
		
		
		logger.info("*** Validating expected message.... ****");
		String confmsg= regpage.AccountConfirmation();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed.......");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		
		}
		catch(Exception e) {
//			logger.error("Test Failed.......");
//			logger.debug("Debug logs....");
			Assert.fail();
		}
	}
	
	

}