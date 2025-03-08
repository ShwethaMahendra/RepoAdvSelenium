package Locators;



import org.openqa.selenium.By;
//org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TypesOfLocators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		/*
		 * driver.get("https://www.saucedemo.com/v1");
		 * driver.manage().window().maximize();
		 * 
		 * //synatx id():----> attributeName="AttributeValue"
		 * driver.findElement(http://By.id("user-name")).sendKeys("standard_user");
		 * 
		 * //synatx name():----> attributeName="AttributeValue"
		 * driver.findElement(http://By.name("password")).sendKeys("secret_sauce");
		 * 
		 * //synatx className():----> attributeName="AttributeValue"
		 * driver.findElement(By.className("btn_action")).click();
		 */

//----------------------------------------------------------------------------------------------------------
		/*
		 * driver.get("https://www.flipkart.com"); // linktext() //
		 * driver.findElement(By.linkText("Kilos")).click();
		 * 
		 * // partialLinkText driver.findElement(By.partialLinkText("Flight")).click();
		 */
//-----------------------------------------------------------------------------------------------------
		// driver.get("https://www.flipkart.com");
		// synatx1:- [AttributeName='AttributeValue']

		// driver.findElement(By.cssSelector("[name='q']")).sendKeys("Nike");

		// synatx2:-htmltag[AttributeName='AttributeValue']
		// driver.findElement(By.cssSelector("input[title='Search for Products, Brands
		// and More']")).sendKeys("Puma");

		/*
		 * driver.get("https://www.saucedemo.com/v1"); // synatx3:- supports only id
		 * Attribute, #----->id in cssSelector // -----> #AttributeValue
		 * 
		 * driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		 * 
		 * // synatx4:- supports only id Attribute, htmltag#AttributeValue
		 * driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce")
		 * ;
		 * 
		 * // synatx5:- supports only className locator, .--->className in cssSelector
		 * // -----> .AttributeValue //
		 * driver.findElement(By.cssSelector(".btn_action")).click();
		 * 
		 * // synatx6:-supports only className locator, .--->className in cssSelector //
		 * ------>htmltag.AttributeValue
		 * driver.findElement(By.cssSelector("input.btn_action")).click();
		 */

//-------------------------------------------------------------------------------------------------
		// xpath
		// AbsoluteXpath----->/:--->Parent traversing to immd child

		// driver.get("https://www.saucedemo.com/v1");
//	driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div/form/input[1]")).sendKeys("standard_user");

		// Relative xpath

		driver.get("https://www.flipkart.com");

		// syntax1:- xpath by Attribute ,@--->Attribute symbol
		// htmltag[@AttributeName='AttributeValue']
		// driver.findElement(By.xpath("//a[@aria-label='Mobiles']")).click();

		// syntax2:- xpath by visibleText ,Text()--->visible text
		// htmltag[text()='AttributeValue']

		// driver.findElement(By.xpath("//span[text()='Flight Bookings']")).click();

		// syntax3:- xpath by contains Attribute ,@--->Attribute symbol
		// htmltag[contains(@AttributeName,'AttributeValue')]

		// driver.findElement(By.xpath("//input[contains(@title,'S')]")).sendKeys("iphone");

		// syntax4:- xpath by contains text ,Text()--->visible text
		// htmltag[contains(text(),'AttributeValue')]

		driver.findElement(By.xpath("//span[contains(text(),'gs')]")).click();

	}

}
