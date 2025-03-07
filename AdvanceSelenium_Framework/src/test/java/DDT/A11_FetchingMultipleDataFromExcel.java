package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class A11_FetchingMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\InsertMultipleData.xlsx");
		//read mode
		Workbook book = WorkbookFactory.create(file);
		DataFormatter format = new DataFormatter();
		
		Sheet sheet = book.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum();
		for (int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			System.out.println(format.formatCellValue(cell));
			System.out.println(rowNum);
			
		}
		
	}

	private static char[] formatCellValue(Cell cell) {
		// TODO Auto-generated method stub
		return null;
	}

}
