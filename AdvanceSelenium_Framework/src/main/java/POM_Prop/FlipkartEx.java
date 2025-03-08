package POM_Prop;

import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FlipkartEx {

	public FlipkartEx(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//@findbys executes or operator function as loop
	@FindBys({@FindBy(name = "q"),@FindBy(xpath = "//input[@title=\"Search for Products, Brands and More\"]")})
	private WebElement searchBar;
	
	//@findall executes and operator function as loop
	@FindAll({@FindBy(className = "_2iLD__"),@FindBy(css = "[aria-label=\"Search for Products, Brands and More\"]")})
	private WebElement searchIcon;

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	//business logic
	public void searchProd(String name) {
		searchBar.sendKeys(name);
		searchIcon.click();
	}
	
//	public FlipkartEx(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//	//automaticall executes or operator
//	@FindBys({@FindBy(className="Pke_EE"),@FindBy(css = "input[type=\"text\"]")})
//	private WebElement searchBar;
//	
//	//@FindAll({@FindBy((css = "[type=\"submit\"]"),@FindBy(xpath = "//button[@aria-label=\"Search for Products, Brands and More\"]")})
//	//private WebElement serachIcon;
//	
//	@FindAll({@FindBy(className = "_2iLD__"),@FindBy(css = "[type=\"submit\"]")})
//	private WebElement serachIcon;
//	
//	public void enterValue(String name)
//	{
//		searchBar.sendKeys(name);
//		serachIcon.click();
//	}
	
}
