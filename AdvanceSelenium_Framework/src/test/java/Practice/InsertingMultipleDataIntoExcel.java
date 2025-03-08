package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingMultipleDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\InsertMultipleData.xlsx");
		Workbook book = WorkbookFactory.create(file);//read mode
		Sheet sheet = book.getSheet("sheet2");
		DataFormatter format = new DataFormatter();
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int allLinks = links.size();
		
		for (int i = 0; i < allLinks; i++) {
			
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			
			cell.setCellValue(links.get(i).getAttribute("href"));
							
			String output = format.formatCellValue(cell);
			System.out.println(output);
		}
		FileOutputStream fos = new FileOutputStream("C:\\Shwetha\\Adv Selenium\\InsertMultipleData.xlsx");
		book.write(fos);
		book.createSheet();
		
		
	}


	}


