// This class is to initalize the UI elements present on the website.


package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class UIElement extends TestBase{
	
	public  UIElement() {
		PageFactory.initElements(driver,this);
	}
	
	
	
	
// Write xpaths and give their names in the below format
	
	
@FindBy(xpath="//button[id='button')") // write Xpath of webelement here	
private WebElement OkButton;  		// Name of the xpath
	  
public void clickOnOk ()		// This method to be called in the @test cases.
	{ 
  	OkButton.click(); // Selenium methods to perform operation on the WebElement.
	}

// Write xpaths and give action name in the above format 


//--------------------------------------------------------------------------
//--------------------------------------------------------------------------
// -----------------Write code below this line only ------------------------



//Click on Skip Tour
@FindBy(xpath="//button[text()='Skip Tour']") 
private WebElement skipTourBtn;  		
	  
public void clickonSkipTour()		
	{ 
	skipTourBtn.click();
	}
//=====================================================================
//Dealer Locator select cluster
@FindBy(xpath="(//input[@id='grouped-demo'])[1]") 
private WebElement selectCluster;  		
	  
public void clickOnSelectCluster()		
	{ 
	selectCluster.click();
	}

//=====================================================================
//Dealer Locator select dealer
@FindBy(xpath="(//input[@id='grouped-demo'])[2]") 
private WebElement selectDealer;  		
	  
public void clickOnselectDealer()		
	{ 
	selectDealer.click();
	}











}
