package POM_Prop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampValidatePage {
	
	public CampValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//public void ValidateCamp(WebDriver driver, String campaignName ) {
	public String ValidateCamp(WebDriver driver ) {
		String CAMPAIGNName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		
//		if (CAMPAIGNName.equalsIgnoreCase(campaignName)) {
//			
//			System.out.println("Campaign Name is "+campaignName);
//		} else {
//			System.out.println("Campaign Name not created");
//		}
		return CAMPAIGNName;
		
		
	}

}
