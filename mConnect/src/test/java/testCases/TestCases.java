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
	String dealerLocatorOutput;
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void dealerLocator(String username, String password) throws InterruptedException, IOException {
		
		

		login.enterUsername(username); 
		login.enterPassword(password);

		login.clickOnLogin();
		Thread.sleep(6000);
		
		driver.get("https://mconnect.pidilite.com/dealer-locator");
		Thread.sleep(500);
		driver.get("https://mconnect.pidilite.com/dealer-locator");
		
		try {
		elementDropdown.selectFieldByPlaceholder("Select Cluster", "First Dealer Locator"+"__"+username,50);
		String one = elementDropdown.getTextByPlaceholder("Select Cluster");
		elementDropdown.selectFieldByPlaceholder("Select Territory", "Second Dealer Locator"+"__"+username,50);
		String two = elementDropdown.getTextByPlaceholder("Select Territory");
		dealerLocatorOutput = one +"__"+ two;
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenshot.save("Failed DealerLocator");
			dealerLocatorOutput = "Failed";
		}
		
		
//		WebElement logout = driver.findElement(By.xpath("//li[text()='Logout']"));
//		logout.click();
		try {
		excel.writeDataToExcel(username, dealerLocatorOutput);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed to write excel");
		}
		Thread.sleep(1);
		}

//========================================================================
	
//	public String first="|";
//	public String second="";
//	public String third="";
//	public String third2="";
//	public String fourth="";
//	public String fourth2="";
//	public String fifth="";
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
		public void MTP(String username, String password) throws InterruptedException {
		String MTPOutput="";
		String first="|";
		String second="";
		String third="";
		String third2="";
		String fourth="";
		String fourth2="";
		String fifth="";
			
		try {
			login.enterUsername(username);
			login.enterPassword(password);
			login.clickOnLogin();
			Thread.sleep(6000);
			try {
			login.enterUsername(username);
			login.enterPassword(password);
			takeScreenshot.save("_LoginFailed_"+username);
			try {
				excel.writeDataToExcel(username, "Login Failed");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Failed to write excel");
			}
			Thread.sleep(1);
			
			
			}catch(Exception e) {
				
			}
			driver.navigate().refresh();
			ElementDropdown elementDropdown = new ElementDropdown();
			elementDropdown.loginSS(username);
			System.out.println(username);
			}catch(Exception e){
				e.printStackTrace();
				takeScreenshot.save("Login Unsuccessful");
			}
			
			driver.get("https://mconnect.pidilite.com/monthly-tour-plan");
//			Thread.sleep(1000);
			driver.get("https://mconnect.pidilite.com/monthly-tour-plan");
			
			
			try {
				try {
			elementDropdown.selectFieldByPlaceholder("Select Cluster", "Cluster"+"__"+username, 50);
			first = "Cluster-->"+elementDropdown.getTextByPlaceholder("Select Cluster");
				}catch(Exception e) {
					takeScreenshot.save("Cluster Failed");
				}
				try {
			elementDropdown.selectFieldByPlaceholder("Select Territory", "FirstMTP"+"__"+username,50);
			second = "Territory-->"+elementDropdown.getTextByPlaceholder("Select Territory");
				}catch(Exception e) {
					takeScreenshot.save("Territory Failed");
				}
				
				
				try { // taking one of the fields either by placeholder or label
				try {		
			elementDropdown.selectFieldByPlaceholder("Select Wss", "SecondMTP"+"__"+username,50);
			third = "Wss-->"+elementDropdown.getTextByPlaceholder("Select Wss");
				}catch(Exception e) {
					
				}
				
				try {		
					elementDropdown.selectFieldByLabel("Select Wss", "SecondMTP"+"__"+username,50);
					third2 = "Wss-->"+elementDropdown.getTextByLabel("Select Wss");
				}catch(Exception e) {
				}
				}catch(Exception e) {
					takeScreenshot.save("Wss Failed");
				}
				
			
				try { // taking one of the fields either by placeholder or label
				try {
					elementDropdown.selectFieldByPlaceholder("Select Town", "SecondMTP"+"__"+username,50);
					fourth = "Town-->"+elementDropdown.getTextByPlaceholder("Select Town");
				}catch(Exception e) {
					
				}
				
				try {
					elementDropdown.selectFieldByLabel("Select Town", "SecondMTP"+"__"+username,50);
					fourth2 = "Town-->"+elementDropdown.getTextByLabel("Select Town");
				}catch(Exception e) {
					
				}
				}catch(Exception e) {
					takeScreenshot.save("Town Failed");
				}
			
			
		
			MTPOutput = first+"__"+second+"__"+third+"__"+third2+"__"+fourth+"__"+fourth2;
			
			}catch(Exception e) {
				e.printStackTrace();
				takeScreenshot.save("MTP Failed");
				System.out.println("MTP Failed");
				MTPOutput = "Failed";
			}
			
		
//			WebElement logout = driver.findElement(By.xpath("//li[text()='Logout']"));
//			logout.click();
			try {
				excel.writeDataToExcel(username, MTPOutput);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Failed to write excel");
			}
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
				takeScreenshot.save("Login Unsuccessful");
			}
			
			//Dealer Tab
			try{
			driver.get("https://mconnect.pidilite.com/my-diary");
			Thread.sleep(1);
			driver.get("https://mconnect.pidilite.com/my-diary");
			
	        elementDropdown.selectFieldByPlaceholder("Select Cluster", "myDairy_"+username,50);
	        String one = elementDropdown.getTextByPlaceholder("Select Cluster");
	        
	        elementDropdown.selectFieldByPlaceholder(2, "myDairy_"+username,50);
	        String two = elementDropdown.getTextByPlaceholder(2);
	        
	        
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
				dealerOutput = "Failed";
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
	        	wssOutput = "Failed";
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
	        	productOutput = "Failed";
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
	        	teamOutput = "Failed";
	        }
	        
	        try {
	        excel.writeDataToExcel(username, "Dealer--("+dealerOutput+")"+"WSS--("+wssOutput+")"+"Product--("+productOutput+")"+"Team--("+teamOutput+")");
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	System.out.println("Failed to write excel");
	        }
	    }
	
	
	
	
}
