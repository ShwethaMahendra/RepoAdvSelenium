package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement accountName;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="email1")
	private WebElement email;
	
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveButton;

	public WebElement getAccountName() {
		return accountName;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business Logic
	public void OrganizationName(String OrganizationName) {
		
		accountName.sendKeys(OrganizationName);
	}
	public void PhoneNo(String PhoneNo) {
		phone.sendKeys(PhoneNo);
	}
	public void emailId(String emailId) {
		email.sendKeys(emailId);
	}
	public void SaveButton() {
		saveButton.click();
	}
}
