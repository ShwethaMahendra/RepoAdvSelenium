package VtigerApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import POM_Prop.CampLookUpImg;
import POM_Prop.CampValidatePage;
import POM_Prop.CreateCampPage;
import POM_Prop.CreateProductPage;
import POM_Prop.HomePage;
import POM_Prop.LoginPageEx;
import POM_Prop.ProductLookUpImgPage;
import POM_Prop.WindowSwitchingPage;

/*4. Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image
->Enter campaignName->Click on Product plus img->Handle the PopUp->Product name should be added to campaign createpage->
click on save Btn->verify whether the campaign name is created in campaign Information page and Logout from the application.*/ 

//*two module with same test script=integration testing(campaign+product)
//public class A4_CreateCampaignWithProduct_IntegrationTesting {

public class A4_CreateCampaignWithProductTest extends BaseClass{
	//public static void main(String[] args) throws Throwable {
	@Test(groups = {"smokeTesting","integrationTesting"})
	public void A4_CreateCampaignWithProductTest() throws Throwable {
//		FileInputStream file = new FileInputStream("./src/test/resources/VtigerLoginDetails.properties");
//		Properties pro = new Properties();
//		pro.load(file);
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
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}				*/ //-----> moved to BaseClass
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver_Utility weblib = new WebDriver_Utility();
		weblib.maximizeWindow(driver);
		weblib.loadTheElement(driver);
		
//		driver.get(URL); ---->moved to Baseclass
		
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

/*		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(UN, PW);  */ //------> moved to BaseClass
		HomePage home = new HomePage(driver);
		home.ClickProdLink();
		ProductLookUpImgPage lookUpImg = new ProductLookUpImgPage(driver);
		lookUpImg.ClickProdLookUpImg();
		
//		Random ran = new Random();//to have random no
//		int ranInt = ran.nextInt(100);//to have next integer value
//		FileInputStream excelFile = new FileInputStream("C:\\Shwetha\\Adv Selenium\\Organization_details(vtiger).xlsx");
//		Workbook book = WorkbookFactory.create(excelFile);
//		
//		String product = book.getSheet("Product").getRow(1).getCell(0).getStringCellValue()+ranInt;
//		driver.findElement(By.name("productname")).sendKeys(product);

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomValue();
		Excel_Utility elib = new Excel_Utility();
		String product = elib.ExcelData("Product", 1, 0)+ranNum;
//		driver.findElement(By.name("productname")).sendKeys(product);
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		CreateProductPage productpage = new CreateProductPage(driver);
		productpage.CreateProdName(product);
		productpage.ClickSaveButton();
		
		Actions act = new Actions(driver);
//		WebElement moreOpt = driver.findElement(By.xpath("//a[text()=\"More\"]"));
//		act.moveToElement(moreOpt).click().perform();
//		driver.findElement(By.name("Campaigns")).click();
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		home.ClickCampLink();
		CampLookUpImg camLookUpImg = new CampLookUpImg(driver);
		camLookUpImg.ClickOnLookUpImg();
		
//		Sheet sheet1 = book.getSheet("Campaign");
//		Row row = sheet1.getRow(0);
//		Cell cell = row.getCell(1);
//		String campaignName = cell.getStringCellValue()+ranInt;
//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		String campaignName = elib.ExcelData("Campaign", 0, 1)+ranNum;
//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		CreateCampPage campaignPage = new CreateCampPage(driver);
		campaignPage.ClickCampname(campaignName);
		campaignPage.ClickAddProduct();
		
//		Set<String> allWindows = driver.getWindowHandles();//collection concept
//		Iterator<String> itr = allWindows.iterator();//collection concept loop
//		
//		while (itr.hasNext()) {
//			String win = itr.next();
//			driver.switchTo().window(win);
//			
//			if (win.contains("Products&action")) {
//				break;
//			}
//		}
		weblib.windowSwitching(driver, "Products&action");//Generic_Utility concept
		
//		driver.findElement(By.name("search_text")).sendKeys(product);
//		driver.findElement(By.name("search")).click();
//		act.moveToElement(driver.findElement(By.xpath("//a[@href='javascript:window.close();']"))).click().perform();
		WindowSwitchingPage switchToWindow = new WindowSwitchingPage(driver);
		switchToWindow.selectProduct(product);
		
//		Set<String> allWin = driver.getWindowHandles();
//		Iterator<String> itr1 = allWin.iterator();
//		while (itr.hasNext()) {
//			 String win = itr.next();
//			 driver.switchTo().window(win);
//			if (win.contains("Campaigns&action")) {
//				break;
//			}
//		}
		weblib.windowSwitching(driver, "Campaigns&action");
		
		
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		campaignPage.ClickOnSaveButton();
		//act.moveToElement(save).click().perform();
		
		Thread.sleep(3000);
//		String CAMPAIGNName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
//		if (CAMPAIGNName.equalsIgnoreCase(campaignName)) {
//			
//			System.out.println("Campaign Name is "+campaignName);
//		} else {
//			System.out.println("Campaign Name not created");
//		}
		
		CampValidatePage validateCamp = new CampValidatePage(driver);
		//validateCamp.ValidateCamp(driver, campaignName);
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
/*		home.logOut();
		driver.close(); */ //---> moved to BaseClass
		
	}
	//------------------------------------------------------------------
	
	@Test(groups = "smokeTesting")
	public void testGroupingRR() {
		
		System.out.println("Testing Grouping Region Regression");
	}
	//------------------------------------------------------------------------
	
	@Test
	public void testWithoutGroupingRR() {
		System.out.println("Testing Grouping Regional Regression without grouping");
	}
	}


