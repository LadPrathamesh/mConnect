package utility;

import testBase.TestBase;

public class LoginAs extends TestBase{
	
	public void tester(String email, String password) throws InterruptedException {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(500);
		login.enterUsername(email);
		login.enterPassword(password);
		login.clickOnLogin();
		Thread.sleep(1000);
		
	}

}
