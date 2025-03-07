package POM_Prop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrgValidatePage {
	
	public OrgValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//public void validateOrg(WebDriver driver, String OrgName) {
	public String validateOrg(WebDriver driver) {
		String newOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//	if (newOrgName.equalsIgnoreCase(OrgName)) {
//		System.out.println("Organization is created");
//	} else {
//		System.out.println("Organization is not created");
//	}
		return newOrgName;
	
	}

}
