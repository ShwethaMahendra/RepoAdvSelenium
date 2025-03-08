package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ChoiceFormat;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

public class Excel_Utility {
	
	public String ExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\Organization_details(vtiger).xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		return value;
		
	}
	//------------------------------------------------------------
		
	public String getExcelDataUsingDataFormatter(String sheetName,int rowNum, int cellNum) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\Organization_details(vtiger).xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	
	//------------------------------------------------------------------------------------
	
	public Object[][] getExcelDataForDataProvider(String sheetname) throws Throwable 
	{
		FileInputStream file = new FileInputStream("./src/test/resources/OrgDtailsTestNG.xlsx");
		Workbook book = WorkbookFactory.create(file);
		
		Sheet sheet = book.getSheet(sheetname);
		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		for (int i = 0; i <lastRow ; i++) {
			for (int j = 0; j < lastCell; j++) {
				
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;	
		
		
	}
	
	
	
	

}
