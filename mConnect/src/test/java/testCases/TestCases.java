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

public class TestCases extends TestBase{


//========================================================================
	@Test 		(groups = {"Smoke","Sanity"})
	public void dealerLocator() throws InterruptedException {
		
		
		login.enterUsername("cs.anand@pidilite.com");
		login.enterPassword("Pidilite@123"); 
		login.clickOnLogin();
		Thread.sleep(6000);
		
		driver.get("https://mconnect.pidilite.com/dealer-locator");
		Thread.sleep(500);
		driver.get("https://mconnect.pidilite.com/dealer-locator");

		elementDropdown.select(1, "First Dealer Locator"+"__"+username);
		elementDropdown.select(2, "Second Dealer Locator"+"__"+username);

		
		
//		WebElement logout = driver.findElement(By.xpath("//li[text()='Logout']"));
//		logout.click();
		
		Thread.sleep(1);
		}

//========================================================================
		@Test 		(groups = {"Smoke","Sanity"})// 07 Aug 2023 | Tester 1    // Sample test case
		public void MTP() throws InterruptedException {
			
			
			login.enterUsername("cs.anand@pidilite.com");
			login.enterPassword("Pidilite@123");
			login.clickOnLogin();
			Thread.sleep(6000);
			
			driver.get("https://mconnect.pidilite.com/monthly-tour-plan");
//			Thread.sleep(1000);
			driver.get("https://mconnect.pidilite.com/monthly-tour-plan");

			elementDropdown.select(1, "FirstMTP");
			elementDropdown.select(2, "SecondMTP");
			elementDropdown.select(3, "ThirdMTP");
			
			
			
			
//			WebElement logout = driver.findElement(By.xpath("//li[text()='Logout']"));
//			logout.click();
			
			Thread.sleep(1);
			}
	
	
	
	
	
	
}
