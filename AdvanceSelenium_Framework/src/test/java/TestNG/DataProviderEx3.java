package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;

public class DataProviderEx3 {

	@Test()
	public void CreateOrganization(String name, String PhNo, String email)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		Java_Utility jLib = new Java_Utility();
		int intNum = jLib.getRandomValue();
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(PhNo);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		driver.quit();
			
		} 
	
	@DataProvider
	public Object[][] getdata() throws Throwable{
		
		Excel_Utility eLib = new Excel_Utility();
		Object[][] data = eLib.getExcelDataForDataProvider("Organization");
		return data;
		
	}
	
}
