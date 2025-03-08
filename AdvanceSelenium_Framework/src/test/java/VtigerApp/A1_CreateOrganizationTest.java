package VtigerApp;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Prop.CreateOrgPage;
import POM_Prop.HomePage;
import POM_Prop.LoginPageEx;
import POM_Prop.OrgLookUpImg;
import POM_Prop.OrgValidatePage;

//1.Login to vtiger application->click on organizations link->click on create organization lookup image
//->Enter organisation name,phone number and email->click on save Btn
//->verify whether the organization is created in Organization Information page and Logout from the application

//converting main method to TestNG

//public class A1_CreateOrganization {
@Listeners(Generic_Utility.ListenersImp.class)

//edited by Eng1 & pushing to Github

//by Eng2
public class A1_CreateOrganizationTest extends BaseClass {
	@Test(retryAnalyzer = Generic_Utility.RetryAnalyserImp.class)
	//public static void main(String[] args) throws Throwable {
		public void a1_CreateOrganizationTest() throws Throwable {
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
		String PW = flib.getCommonData("password"); */ // --->moved into BaseClass
		
//		WebDriver driver;  --->moved into BaseClass
		
/*		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}								 */ //--> moved to baseclass & extended with heirarchical inheritance 
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//load the element inside the page

/*		WebDriver_Utility weblib = new WebDriver_Utility();
		weblib.maximizeWindow(driver);
		weblib.loadTheElement(driver);  */ //----> can move to BaseClass
		
//		driver.get(URL);  -----> moved into baseclass
		/*Normal Approach*/
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//		driver.findElement(By.id("submitButton")).click();
		
		/*get it from POM class with getter method*/
//		LoginPageEx login = new LoginPageEx(driver);
//		login.getUserTextField().sendKeys(UN);
//		login.getPasswordField().sendKeys(PW);
//		login.getLoginButton().click();
		
		/*using businesslogic*/
/*		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(UN, PW); */ //-------> moved to baseclass BM
		//login.getLoginButton().click();("not required as it has already applied in loginToApp meth in POM class ")
		
		//Robot r = new Robot();
		//r.keyPress(KeyEvent.VK_ENTER);
		
	//	driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click(); /*hardcoded*/
		HomePage home = new HomePage(driver);
		home.ClickOrgLink();
		
	//	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		OrgLookUpImg lookupImg = new OrgLookUpImg(driver);
		lookupImg.ClickOnOrgLookUpImg();
		
//		Random ran = new Random();//to create the random data
//		int ranInt = ran.nextInt(1000);//to create random value next to actual data while each testing(actual value in excel doesnt change as we use as concatenate with actual data)
		//as organization name is mandatory & it wont accept the duplicate name while running script for 2nd time to test after saving the name we use random()
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomValue();
		
//		FileInputStream file1 = new FileInputStream("C:\\Shwetha\\Adv Selenium\\Organization_details(vtiger).xlsx");
//		Workbook book = WorkbookFactory.create(file1);//read mode
//		Sheet sheet = book.getSheet("Organization");//navigating to particular sheet in excel
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(1);
//		String OrgName = cell.getStringCellValue()+ranInt;
//		System.out.println(OrgName);
//		driver.findElement(By.name("accountname")).sendKeys(OrgName);
	
		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.ExcelData("Organization", 0, 1)+ranNum;
		System.out.println(OrgName);
		
//		driver.findElement(By.name("accountname")).sendKeys(OrgName);	-->hardcoded	
		CreateOrgPage createOrg = new CreateOrgPage(driver);
		createOrg.OrganizationName(OrgName);
		
		//-------------------------------------------------------------------------------------------------------------
		
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row1.getCell(1);
//		DataFormatter format = new DataFormatter();
//		String phone = format.formatCellValue(cell1);
//		System.out.println(phone);
//		driver.findElement(By.id("phone")).sendKeys(phone);
		
		String phone = elib.getExcelDataUsingDataFormatter("Organization", 1, 1);
		System.out.println(phone);
//		driver.findElement(By.id("phone")).sendKeys(phone);
		createOrg.PhoneNo(phone);
	//-----------------------------------------------------------------------------------------------------------

		
//		Row row2 = sheet.getRow(2);
//		Cell cell2 = row2.getCell(1);
//		String email = cell2.getStringCellValue();
//		System.out.println(email);
//		driver.findElement(By.id("email1")).sendKeys(email);
//		
		String email = elib.getExcelDataUsingDataFormatter("Organization", 2, 1);
		System.out.println(email);
//		driver.findElement(By.id("email1")).sendKeys(email);
		createOrg.emailId(email);;
		
//		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		createOrg.SaveButton();
		
/*		String OrganizationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		System.out.println(OrganizationName);
		if (OrganizationName.contains(OrgName)) {
			
			System.out.println("Organization name created");
		} else {
			System.out.println("Organization name not created");
		}  */ //--------> POM class
		
//Assert.fail("Iam failing the test script to check the listeners(screenshot)");
		
		OrgValidatePage validate = new OrgValidatePage(driver);
		//validate.validateOrg(driver, OrgName);
		String actualData = validate.validateOrg(driver);
		Assert.assertEquals(actualData, OrgName);
		System.out.println("act & exp data matching");
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
//		home.logOut();	//moved to baseclass AM	
//		driver.quit();	//moved to baseclass AC	
}

}
