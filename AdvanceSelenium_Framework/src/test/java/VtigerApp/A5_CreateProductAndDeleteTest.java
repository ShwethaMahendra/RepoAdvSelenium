package VtigerApp;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Prop.CreateProductPage;
import POM_Prop.DeleteProd;
import POM_Prop.DeletedProdValidatePage;
import POM_Prop.HomePage;
import POM_Prop.LoginPageEx;
import POM_Prop.ProdValidatePage;
import POM_Prop.ProductLookUpImgPage;

/*5.Login to vtiger application->click on products link->click on create product lookup image->Enter product name
->click on save Btn->verify whether the product is created in product Information page->click on product link
->navigate to product table page ->select the product created checkbox->click on delete
->Handle the Alert popup and verify product deleted or not and Logout from the application.*/
 
 //public class A5_CreateProductAndDelete {
 public class A5_CreateProductAndDeleteTest extends BaseClass{

	 //public static void main(String[] args) throws Throwable {
		@Test
		public void A5_CreateProductAndDelete() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_Utility weblib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		
/*		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String UN = flib.getCommonData("username");
		String PW = flib.getCommonData("password");
				
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		*/  //-----> moved to BaseClass
		weblib.maximizeWindow(driver);
		weblib.loadTheElement(driver);
		//driver.get(URL);  //------> moved to BaseClass
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//		driver.findElement(By.id("submitButton")).click();
		
//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
/*		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(UN, PW);  */ //------->moved to BaseClass
		HomePage home = new HomePage(driver);
		home.ClickProdLink();
		ProductLookUpImgPage lookUpImg = new ProductLookUpImgPage(driver);	
		lookUpImg.ClickProdLookUpImg();
		
		int ranNum = jlib.getRandomValue();
		Excel_Utility elib = new Excel_Utility();
		String product = elib.ExcelData("product", 1, 0)+ranNum;
//		driver.findElement(By.name("productname")).sendKeys(product);
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		CreateProductPage productPage = new CreateProductPage(driver);
		productPage.CreateProdName(product);
		productPage.ClickSaveButton();
		
//		String productName = driver.findElement(By.id("dtlview_Product Name")).getText();
//		if (productName.equalsIgnoreCase(product)) {
//			System.out.println("Product created with name "+productName);
//		}
//		else
//			System.out.println("Product not created");
		ProdValidatePage validate = new ProdValidatePage(driver);
		validate.ValidateProduct(driver, product);
		
//		driver.findElement(By.linkText("Products")).click();
		home.ClickProdLink();
		
		//driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='Product Name']/../preceding-sibling::td/input[@type=\"checkbox\"]")).click;
		//making dynamic xpath
//		driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+product+"']/../preceding-sibling::td/input[@type=\"checkbox\"]")).click();
//		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		DeleteProd delete = new DeleteProd(driver);
		Thread.sleep(2000);
        delete.selectPrdCheckBox(driver, product);
        delete.clickOnDeleteButton();

		
		//driver.switchTo().alert().accept();
		weblib.alertAccept(driver);
		
//		 WebElement data = driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+product+"']"));
//		if (data.equals(product)) {
//			System.out.println("Product is available");
//		}
//		else
//			System.out.println("Product is deleted");
		 delete.ValidateProdName(driver, product);
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

/*		home.logOut();
		driver.quit(); */ //--------> moved BaseClass
	}
	
}
