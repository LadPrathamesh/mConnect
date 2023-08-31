package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testBase.TestBase;

public class ElementDropdown extends TestBase{
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	public void select(int fieldPosition, String screenshotName) throws InterruptedException {
	Actions actions = new Actions(driver);
	WebElement firstField = driver.findElement(By.xpath("(//input[@id='grouped-demo'])["+fieldPosition+"]"));
	firstField.click();
	Thread.sleep(3000);
    actions.moveToElement(firstField).perform();
    actions.moveByOffset(0, 50).click().perform();
	takeScreenshot.save(screenshotName);
	String firstFieldText = firstField.getAttribute("value");
	System.out.println(firstFieldText);
	}
}
