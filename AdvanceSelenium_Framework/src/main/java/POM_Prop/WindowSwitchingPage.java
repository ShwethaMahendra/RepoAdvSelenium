package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingPage {

	public WindowSwitchingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="search_text")
	private WebElement enterPrdName;

	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement selectProd;
	
	public WebElement getEnterPrdName() {
		return enterPrdName;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getSelectProd() {
		return selectProd;
	}

	public void selectProduct(String ProdName) {
		enterPrdName.sendKeys(ProdName);
		searchButton.click();
		selectProd.click();
	}

	
	
	
	
}
	
	

