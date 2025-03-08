package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Prop.HomePage;
import POM_Prop.LoginPageEx;


public class BaseClass {

	public WebDriver driver;//make browser global
	public static WebDriver sdriver;// Static webdriver for screenshot(listeners)
	File_Utility fLib = new File_Utility();
	WebDriver_Utility weblib = new WebDriver_Utility();
		
	@BeforeSuite(groups = {"smokeTesting","regressionTesting","integrationTesting"})
	public void BS()
	{
		System.out.println("Open DataBase Connection");
	}
	
	@BeforeTest(groups = {"smokeTesting","RegressionTesting","integrationTesting"})
	public void BT()
	{
		System.out.println("Open Parallel Execution");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTesting","integrationTesting","regressionTesting"})
	//public void BC(String BROWSER) throws Throwable {
	public void BC() throws Throwable {
		System.out.println("Launching Browser");
		//instead of reading from file, getting data though testNG parameters with @parameters
		String BROWSER = fLib.getCommonData("browser");
	//	String BROWSER = System.getProperty("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		else
			driver=new ChromeDriver();
		
		sdriver=driver;
	}
	
	@BeforeMethod(groups = {"smokeTesting","integrationTesting","regressionTesting"})
	public void BM() throws Throwable {
		System.out.println("Login to the App");
		
		weblib.maximizeWindow(driver);
		weblib.loadTheElement(driver);
				
		String URL = fLib.getCommonData("url");
		String UN = fLib.getCommonData("username");
		String PW = fLib.getCommonData("password");
//		String URL = System.getProperty("url");
//		String UN = System.getProperty("username");
//		String PW = System.getProperty("password");
		
		
		driver.get(URL);
		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(UN, PW);
	}
	
	@AfterMethod(groups = {"smokeTesting","integrationTesting","regressionTesting"})
	public void AM() {
		System.out.println("Logoutfrom App");
		HomePage home = new HomePage(driver);
		home.logOut();
	}
	
	@AfterClass(groups = {"smokeTesting","integrationTesting","regressionTesting"})
	public void AC() {
		System.out.println("Close the Brwoser");
		
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTesting","integrationTesting","regressionTesting"})
	public void AT() {
		System.out.println("Close the Parallel Execution");
	}
	
	@AfterSuite(groups = {"smokeTesting","integrationTesting","regressionTesting"})
	public void AS() {
		System.out.println("Close te DataBase Connection");
	}
}
