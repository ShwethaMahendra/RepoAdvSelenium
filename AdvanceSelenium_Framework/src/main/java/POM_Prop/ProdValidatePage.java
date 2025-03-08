package POM_Prop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdValidatePage {
	
	public ProdValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	@FindBy(id = "dtlview_Product Name")
//	private WebElement createdProdName;
//
//	public WebElement getCreatedProdName() {
//		return createdProdName;
//	}
//	
//	public void ValidateProduct(String product) {
//		String ProdName = createdProdName.getText();
//		if (ProdName.equalsIgnoreCase(product)) {
//			System.out.println("Product Name is"+product);
//		}
//		else
//			System.out.println("Product is not create");

	//or we can also write verification directly inside the method
	
	public void ValidateProduct(WebDriver driver, String product ) {
		String ProdName = driver.findElement(By.id("dtlview_Product Name")).getText();
		if (ProdName.equalsIgnoreCase(product)) {
			System.out.println("Product Name is "+product);
		}
		else
			System.out.println("Product is not create");
	}

	
}
