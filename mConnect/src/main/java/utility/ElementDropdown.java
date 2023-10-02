package utility;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testBase.TestBase;

public class ElementDropdown extends TestBase{
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	
	
	public void loginSS(String username) throws InterruptedException {
		WebElement sidebar = driver.findElement(By.xpath("//a[@role='button']"));
		sidebar.click();
		Thread.sleep(1000);
		takeScreenshot.save("_LoginSucess_"+username);
	}
	
	public String inputValueMethod() {
		ElementDropdown el = new ElementDropdown();
		String getValue = el.inputValueMethod();
		return getValue;
		
	}
	
	
	//below for selecting cluster which is not present for some users
	public void selectFieldByPlaceholder(String fieldName, String screenshotName,int pos) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement firstField = driver.findElement(By.xpath("//input[@placeholder='"+fieldName+"']"));
		firstField.click();
		Thread.sleep(3000);
	    actions.moveToElement(firstField).perform();
	    takeScreenshot.save(screenshotName);
	    actions.moveByOffset(0, pos).click().perform();
		}
	public String getTextByPlaceholder(String fieldName) {
		WebElement firstField = driver.findElement(By.xpath("//input[@placeholder='"+fieldName+"']"));
		String inputValue = firstField.getAttribute("value");
		return inputValue;
	}
	
	
	
	
	
	
	
	
	public void selectFieldByLabel(String fieldName, String screenshotName,int pos) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement firstField = driver.findElement(By.xpath("//input[@name='"+fieldName+"']"));
		firstField.click();
		Thread.sleep(3000);
	    actions.moveToElement(firstField).perform();
	    takeScreenshot.save(screenshotName);
	    actions.moveByOffset(0, pos).click().perform();
		}
	public String getTextByLabel(String fieldName) {
		WebElement firstField = driver.findElement(By.xpath("//input[@placeholder='"+fieldName+"']"));
		String inputValue = firstField.getAttribute("value");
		return inputValue;
	}
	
	
	
	

	
}
