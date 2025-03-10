package POM_Prop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProd {
	
	public DeleteProd(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement deletePrd;
	
	public void selectPrdCheckBox(WebDriver driver,String prodName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prodName+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public void clickOnDeleteButton()
	{
		deletePrd.click();
	}
	
	public void ValidateProdName(WebDriver driver,String prodData)
	{
		List<WebElement> allprd = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag=false;
		
		for (WebElement prodName : allprd)
		{
			String actData = prodName.getText();
			if(actData.contains(prodData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product data is deleted");
		}
		else
		{
			System.out.println("Product data is not deleted");
		}
		
	}
}
