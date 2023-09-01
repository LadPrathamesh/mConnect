package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.TestBase;
import utility.ElementDropdown;
import utility.ExcelDataProvider;
import utility.ExcelHandling;

public class TestCases extends TestBase{
	ExcelWrite excel = new ExcelWrite();


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
		public void MTP(String username, String password) throws InterruptedException {
			
			
			login.enterUsername(username);
			login.enterPassword(password);
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
	    public void myDairy(String username, String password) throws InterruptedException, IOException {
	        // Your test code here
			login.enterUsername(username);
			login.enterPassword(password);
			login.clickOnLogin();
			Thread.sleep(6000);
			ElementDropdown ed = new ElementDropdown();
			ed.loginSS();
			
			driver.get("https://mconnect.pidilite.com/my-diary");
			Thread.sleep(1);
			driver.get("https://mconnect.pidilite.com/my-diary");
	        elementDropdown.select(1, "myDairy_"+username,50);
	        elementDropdown.select(2, "myDairy_"+username,50);
	        elementDropdown.select2(1, "myDairy_"+username,50);
	        elementDropdown.select2(1, "myDairy_"+username,-50);
	        takeScreenshot.save("myDairy_"+username+"_");
	        
	      //button[text()='WSS']
	        WebElement wss = driver.findElement(By.xpath("//button[text()='WSS']"));
	        wss.click();
	        elementDropdown.select(3, "wss_"+username,50);
	        elementDropdown.select2(2, "wss_"+username,50);
	        takeScreenshot.save("wss_"+username+"_");
	       
	        WebElement product = driver.findElement(By.xpath("//button[text()='Product']"));
	        product.click();
	        elementDropdown.select2(3, "product_"+username,50);
	        takeScreenshot.save("product"+username+"_");
	        
	        WebElement team = driver.findElement(By.xpath("//button[text()='Team']"));
	        team.click();
	        
	        elementDropdown.select(4, "team_"+username,50);
	        elementDropdown.select(5, "team_"+username,50);
	        
	        
	        
	        String iVV = elementDropdown.inputValueMethod();
//	        excel.writeDataToExcel(username, iVV);
			System.out.println(iVV);
	    }
	
	
	
	
}
