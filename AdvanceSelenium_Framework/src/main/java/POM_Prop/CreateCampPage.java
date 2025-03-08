package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {
	
	public CreateCampPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campname;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement addProduct;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getCampname() {
		return campname;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}
		
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void ClickCampname (String campaignname) {
		campname.sendKeys(campaignname);
	}
	public void ClickAddProduct() {
		addProduct.click();
	}
	public void ClickOnSaveButton() {
		saveButton.click();
	}
	
}
