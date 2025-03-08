package POM_Prop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImgPage {
	
	public ProductLookUpImgPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement lookupImg;

	@FindBy(xpath = "//input[@value=\\\"Delete\\\"]")
	private WebElement deleteProd;
	
	public WebElement getLookupImg() {
		return lookupImg;
	}
	
	public WebElement getDeleteProd() {
		return deleteProd;
	}

	public void ClickProdLookUpImg() {
		lookupImg.click();
	}
	
	public void prodPage(WebDriver driver, String product) {
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+product+"']/../preceding-sibling::td/input[@type=\"checkbox\"]")).click();
	}
	public void deleteProd() {
		deleteProd.click();
	}
}
