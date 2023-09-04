package testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testBase.TestBase;
import utility.ElementDropdown;
import utility.ExcelDataProvider;

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
			ElementDropdown ed = new ElementDropdown();
			ed.loginSS(username);
			
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
	
	
	public String dealerOutput;
	public String wssOutput;
	public String productOutput;
	public String teamOutput;
		@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	    public void myDairy(String username, String password) throws InterruptedException, IOException {
	        
			try {
			login.enterUsername(username);
			login.enterPassword(password);
			login.clickOnLogin();
			Thread.sleep(6000);
			ElementDropdown elementDropdown = new ElementDropdown();
			elementDropdown.loginSS(username);
			System.out.println(username);
			}catch(Exception e){
				e.printStackTrace();
				takeScreenshot.save("Login Unsuccessful_");
			}
			try{
			driver.get("https://mconnect.pidilite.com/my-diary");
			Thread.sleep(1);
			driver.get("https://mconnect.pidilite.com/my-diary");
			
	        elementDropdown.select(1, "myDairy_"+username,50);
	        String one = elementDropdown.getTextField1(1);
	        elementDropdown.select(2, "myDairy_"+username,50);
	        String two = elementDropdown.getTextField1(2);
	        elementDropdown.select2(1, "myDairy_"+username,50);
	        String three = elementDropdown.getTextField2(1);
	        elementDropdown.select2(1, "myDairy_"+username,-50);
	        String four = elementDropdown.getTextField2(1);
	        takeScreenshot.save("myDairy_"+username);
	        dealerOutput = one+"__"+two+"__"+three+"__"+four;
			}catch(Exception e) {
				e.printStackTrace();
				takeScreenshot.save("Dealer Failed");
				System.out.println("Dealer tab issue");
			}
	        try {
	      //button[text()='WSS']
	        WebElement wss = driver.findElement(By.xpath("//button[text()='WSS']"));
	        wss.click();
	        elementDropdown.select(3, "wss_"+username,50);
	        String one = elementDropdown.getTextField1(3);
	        elementDropdown.select2(2, "wss_"+username,50);
	        String two= elementDropdown.getTextField2(2);
	        takeScreenshot.save("wss_"+username);
	        wssOutput = one+"__"+two;
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	System.out.println("WSS Failed");
	        	takeScreenshot.save("WSS Failed");
	        }
	        try {
	       //Product
	        WebElement product = driver.findElement(By.xpath("//button[text()='Product']"));
	        product.click();
	        elementDropdown.select2(3, "product_"+username,50);
	        String one = elementDropdown.getTextField2(3);
	        takeScreenshot.save("product"+username);
	        productOutput = one;
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	System.out.println("Failed Product");
	        	takeScreenshot.save("Failed Product");
	        }
	        try {
	        //Team
	        WebElement team = driver.findElement(By.xpath("//button[text()='Team']"));
	        team.click();
	        
	        elementDropdown.select(4, "team_"+username,50);
	        String one = elementDropdown.getTextField1(4);
	        elementDropdown.select(5, "team_"+username,50);
	        String two = elementDropdown.getTextField1(5);
	        teamOutput = one+"__"+two;
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	System.out.println("Failed Team");
	        	takeScreenshot.save("Failed Team");
	        }
	        
	        
	        excel.writeDataToExcel(username, "Dealer--("+dealerOutput+")"+"WSS--("+wssOutput+")"+"Product--("+productOutput+")"+"Team--("+teamOutput+")");
	    }
	
	
	
	
}
