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
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Prop.CampLookUpImg;
import POM_Prop.CampValidatePage;
import POM_Prop.CreateCampPage;
import POM_Prop.HomePage;
import POM_Prop.LoginPageEx;

//public class A2_CreateCampaign {
/*change the classname to ends with Test & extend baseclass as hierarchical inheritence
(multiple classes inherit from a single superclass)*/

@Listeners(Generic_Utility.ExtentReport.class)
public class A2_CreateCampaignTest extends BaseClass{
		
//	public static void main(String[] args) throws Throwable {
	
	@Test (groups = "smokeTesting")//declare @Test annotation after class before method instead of main method in TestNG
		public void A2_CreateCampaignTest() throws Throwable {
		
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
		} 								*/ //-----> moved to BaseClass
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver_Utility weblib = new WebDriver_Utility();
		weblib.maximizeWindow(driver);
		weblib.loadTheElement(driver);
		
//		driver.get(URL); --------> moved to BaseClass
		
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//		driver.findElement(By.id("submitButton")).click();
		
/*		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(UN, PW); */ //----> moved to BaseClass
		
//		Actions act = new Actions(driver);
//		WebElement moreOpt = driver.findElement(By.xpath("//a[text()=\"More\"]"));
//		act.moveToElement(moreOpt).click().perform();
//		driver.findElement(By.name("Campaigns")).click();
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		HomePage home = new HomePage(driver);
		home.ClickMoreLink();
		home.ClickCampLink();
		
		CampLookUpImg lookUp = new CampLookUpImg(driver);
		lookUp.ClickOnLookUpImg();
		
//		Random ran = new Random();//to have random no
//		int ranNum = ran.nextInt(100);//to have next integer value
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomValue();
		
//		FileInputStream excelFile = new FileInputStream("C:\\Shwetha\\Adv Selenium\\Organization_details(vtiger).xlsx");
//		Workbook book = WorkbookFactory.create(excelFile);
//		Sheet sheet = book.getSheet("Campaign");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(1);
//		String campaignName = cell.getStringCellValue()+ranNum;
//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		Excel_Utility elib = new Excel_Utility();
		String campaignName = elib.ExcelData("Campaign", 0, 1)+ranNum;
		
//		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		CreateCampPage camppage = new CreateCampPage(driver);
		camppage.ClickCampname(campaignName);
		camppage.ClickOnSaveButton();
		
//		String CAMPAIGNName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
//		if (CAMPAIGNName.equalsIgnoreCase(campaignName)) {
//			
//			System.out.println("Campaign Name is "+campaignName);
//		} else {
//			System.out.println("Campaign Name not created");
//		}
		
		CampValidatePage validate = new CampValidatePage(driver);
		//validate.ValidateCamp(driver, campaignName);
		String actData = validate.ValidateCamp(driver);
		Assert.assertEquals(actData, campaignName);
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
/*		home.logOut();
		driver.close(); */ //---->moved to BaseClass
	}		
		//------------------------------------------------------------
		
	// additonal methods are created to do regional regression testing which executes only selected methods
	@Test
	public void m2()
	{
		System.out.println("I am method 2");
	}
	
	//-------------------------------------------------------------
		
		
		@Test
		public void m3()
		{
			System.out.println("I am Method3");
		}
	
	

}
