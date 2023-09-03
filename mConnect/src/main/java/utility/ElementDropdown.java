package utility;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testBase.TestBase;

public class ElementDropdown extends TestBase{
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	public void select(int fieldPosition, String screenshotName, int pos) throws InterruptedException {
	Actions actions = new Actions(driver);
	
	WebElement firstField = driver.findElement(By.xpath("(//input[@id='grouped-demo'])["+fieldPosition+"]"));
	firstField.click();
	Thread.sleep(3000);
    actions.moveToElement(firstField).perform();
    actions.moveByOffset(0, pos).click().perform();
	takeScreenshot.save(screenshotName);
	String firstFieldText = firstField.getAttribute("value");
	System.out.println(firstFieldText);
	String inputValue = firstField.getAttribute("value");
	
	}
	public void loginSS() throws InterruptedException {
		WebElement sidebar = driver.findElement(By.xpath("//a[@role='button']"));
		sidebar.click();
		Thread.sleep(1000);
		takeScreenshot.save("_LoginSucess_");
	}
	
	public String inputValueMethod() {
		ElementDropdown el = new ElementDropdown();
		String getValue = el.inputValueMethod();
		return getValue;
		
	}
	
	public void select2(int fieldPositionSelect2, String screenshotName,int pos) throws InterruptedException {
		Actions actions = new Actions(driver);
		String xpath = ElementDropdown.xPathSelect(fieldPositionSelect2);
		WebElement firstField = driver.findElement(By.xpath(xpath));
		firstField.click();
		Thread.sleep(3000);
	    actions.moveToElement(firstField).perform();
	    actions.moveByOffset(0, pos).click().perform();
		takeScreenshot.save(screenshotName);
		String firstFieldText = firstField.getAttribute("value");
		System.out.println(firstFieldText);
		}
	
	public static String xPathSelect(int fieldPositionSelect2) {
		return "(//input[@id='grouped-demos'])["+fieldPositionSelect2+"]";
		
	}
	
}
