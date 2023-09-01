package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.TestBase;
import utility.ExcelDataProvider;

public class TestCases extends TestBase{


//========================================================================
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void dealerLocator(String username, String password) throws InterruptedException {
		
		

		login.enterUsername(username); 
		login.enterPassword(password);

		login.clickOnLogin();
		Thread.sleep(6000);
		
		driver.get("https://mconnect.pidilite.com/dealer-locator");
		Thread.sleep(500);
		driver.get("https://mconnect.pidilite.com/dealer-locator");

		elementDropdown.select(1, "First Dealer Locator"+"__"+username,50);
		elementDropdown.select(2, "Second Dealer Locator"+"__"+username,50);

		
		
//		WebElement logout = driver.findElement(By.xpath("//li[text()='Logout']"));
//		logout.click();
		
		Thread.sleep(1);
		}

//========================================================================
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
		public void MTP() throws InterruptedException {
			
			
			login.enterUsername("cs.anand@pidilite.com");
			login.enterPassword("Pidilite@123");
			login.clickOnLogin();
			Thread.sleep(6000);
			
			driver.get("https://mconnect.pidilite.com/monthly-tour-plan");
//			Thread.sleep(1000);
			driver.get("https://mconnect.pidilite.com/monthly-tour-plan");

			elementDropdown.select(1, "FirstMTP",50);
			elementDropdown.select(2, "SecondMTP",50);
			elementDropdown.select(3, "ThirdMTP",50);
			
			
			
			
//			WebElement logout = driver.findElement(By.xpath("//li[text()='Logout']"));
//			logout.click();
			
			Thread.sleep(1);
			}
	
		@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	    public void myDairy(String username, String password) throws InterruptedException {
	        // Your test code here
			login.enterUsername("cs.anand@pidilite.com");
			login.enterPassword("Pidilite@123");
			login.clickOnLogin();
			Thread.sleep(6000);
			
			driver.get("https://mconnect.pidilite.com/my-diary");
			Thread.sleep(1);
			driver.get("https://mconnect.pidilite.com/my-diary");
	        elementDropdown.select(1, "myDairy_"+username,50);
	        elementDropdown.select(2, "myDairy_"+username,50);
	        elementDropdown.select2(1, "myDairy_"+username,-50);
	        
	      //button[text()='WSS']
			
	    }
	
	
	
	
}
