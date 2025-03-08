package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="productname")
	private WebElement Prodname;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public WebElement getProdname() {
		return Prodname;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void CreateProdName(String prodName) {
		Prodname.sendKeys(prodName);
	}
	public void ClickSaveButton() {
		saveButton.click();
	}
}
