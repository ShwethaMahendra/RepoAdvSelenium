package VtigerApp;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Prop.CreateProductPage;
import POM_Prop.HomePage;
import POM_Prop.LoginPageEx;
import POM_Prop.ProdValidatePage;
import POM_Prop.ProductLookUpImgPage;
/*change the classname to ends with Test & extend baseclass as hierarchical inheritence
(multiple classes inherit from a single superclass)*/

//public class A3_CreateProductName {
	public class A3_CreateProductNameTest extends BaseClass{
	
		@Test(groups = "regressionTesting") //declare @Test annotation after class before method instead of main method in TestNG
//		public static void main(String[] args) throws Throwable {
		public void A3_CreateProductNameTest() throws Throwable {
			
//		FileInputStream file = new FileInputStream("./src/test/resources/VtigerLoginDetails.properties");
//		Properties pro = new Properties();
//		pro.load(file);
//		
//		String BROWSER = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String UN = pro.getProperty("username");
//		String PW = pro.getProperty("password");
		
/*		File_Utility flib = new File_Utility();
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String UN = flib.getCommonData("username");
		String PW = flib.getCommonData("password");
		
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("brave")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}		*/ //----> moved to BaseClass
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriver_Utility weblib = new WebDriver_Utility(); //moved to baseclass
//		weblib.maximizeWindow(driver);
//		weblib.loadTheElement(driver);//with inplicitlywait
				
//		driver.get(URL)  -------> Moved to BaseClass
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

/*		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(UN, PW); */ // ------>  moved to BaseClass
		HomePage home = new HomePage(driver);
		home.ClickProdLink();
		ProductLookUpImgPage lookUpImg = new ProductLookUpImgPage(driver);
		lookUpImg.ClickProdLookUpImg();
		
		//int ranInt = new Random().nextInt(100);//create random class with next intNo
		Java_Utility jlib = new Java_Utility();	
		int ranInt = jlib.getRandomValue();
		
//		FileInputStream excelfile = new FileInputStream("C:\\Shwetha\\Adv Selenium\\Organization_details(vtiger).xlsx");
//		Workbook book = WorkbookFactory.create(excelfile);
//		String product = book.getSheet("Product").getRow(1).getCell(0).getStringCellValue()+ranInt;
//		driver.findElement(By.name("productname")).sendKeys(product);
		
		Excel_Utility elib = new Excel_Utility();
		String product = elib.ExcelData("Product", 1, 0)+ranInt;
//		driver.findElement(By.name("productname")).sendKeys(product);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateProductPage ProdName = new CreateProductPage(driver);
		ProdName.CreateProdName(product);
		ProdName.ClickSaveButton();
		
		
//		String productName = driver.findElement(By.id("dtlview_Product Name")).getText();
//				
//		if (productName.equalsIgnoreCase(product)) {
//			System.out.println("Product name is "+productName);
//		} else {
//			System.out.println("product not created");
//		}
		
		ProdValidatePage validate = new ProdValidatePage(driver);
		validate.ValidateProduct(driver, product);
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

/*		home.logOut();
		driver.quit(); */  //-----> Moved to BaseClass
		

	}

}
