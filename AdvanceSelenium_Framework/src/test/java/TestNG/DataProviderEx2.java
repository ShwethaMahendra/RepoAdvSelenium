package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;

public class DataProviderEx2 {
	
	@Test(dataProvider = "getData")
	private void CreateOrganization(String name, String contact, String email) throws Throwable {
	
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//		driver.findElement(By.name("accountname")).sendKeys(name);
//		driver.findElement(By.id("phone")).sendKeys(contact);
//		driver.findElement(By.id("email1")).sendKeys(email);
//		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(contact);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		driver.quit();
	}
	
	public String ExcelData(String sheetname, int rowNum, int cellNum) throws Throwable {
			
		FileInputStream file = new FileInputStream("./src/test/resources/OrgDtailsTestNG.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		
		return value;
	}
	
		@DataProvider
		public Object[][] getData() throws Throwable{
					
			Random ran = new Random();
			int ranInt = ran.nextInt(500);
						
			Object[][] objArr = new Object[3][3];
			objArr[0][0]= ExcelData("Organization", 0, 0);
			objArr[0][1]= ExcelData("Organization", 0, 1);
			objArr[0][2]= ExcelData("Organization", 0, 2);
			
			objArr[1][0]= ExcelData("Organization", 1, 0);
			objArr[1][1]= ExcelData("Organization", 1, 1);
			objArr[1][2]= ExcelData("Organization", 1, 2);
			
			objArr[2][0]= ExcelData("Organization", 2, 0);
			objArr[2][1]= ExcelData("Organization", 2, 1);
			objArr[2][2]= ExcelData("Organization", 2, 2);
	
			//Hard Coding
//			objArr[0][0]="Dazzles"+ranInt;
//			objArr[0][1]="9876543210";
//			objArr[0][2]="dazzles@gmail.com";
//			
//			objArr[1][0]="A2B"+ranInt;
//			objArr[1][1]="1234567890";
//			objArr[1][2]="A2B@gmail.com";
//			
//			objArr[2][0]="A2Z"+ranInt;
//			objArr[2][1]="9876598765";
//			objArr[2][2]="A2Z@gmail.com";
			
			
			return objArr;
		}
		
	}


