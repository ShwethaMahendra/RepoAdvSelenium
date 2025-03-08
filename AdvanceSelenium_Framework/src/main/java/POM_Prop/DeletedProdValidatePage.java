package POM_Prop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DeletedProdValidatePage {

	public DeletedProdValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateDeletedProd(WebDriver driver,String product ) {
	
		 WebElement data = driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+product+"']"));
			if (data.equals(product)) {
				System.out.println("Product is available");
			}
			else
				System.out.println("Product is deleted");
			
}
}

