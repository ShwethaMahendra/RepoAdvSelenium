package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A10_InsertMultipledataIntoExcel {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		List<WebElement> linkList = driver.findElements(By.xpath("//a"));
		Thread.sleep(2000);

		//for (WebElement link : linkList) {
			//System.out.println(link.getAttribute("href"));}
		
	
	FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\InsertMultipleData.xlsx");
 
	Workbook book = WorkbookFactory.create(file);	
	
	Sheet sheet = book.getSheet("sheet1");
	
	for (int i = 0; i < linkList.size(); i++) {
		
		
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(linkList.get(i).getAttribute("href"));
		
		String data = cell.getStringCellValue();
		System.out.println(data);

	}
	int size = linkList.size();
	System.out.println(size);
	
	FileOutputStream file1 = new FileOutputStream("C:\\\\Shwetha\\\\Adv Selenium\\\\InsertMultipleData.xlsx");
	book.write(file1);
	book.createSheet();
	
	
	}

}
