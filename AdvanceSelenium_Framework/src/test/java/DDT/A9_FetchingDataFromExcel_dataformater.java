package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class A9_FetchingDataFromExcel_dataformater {

	public static void main(String[] args) throws Throwable {

		FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\ExcelNumericData..xlsx");
		
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Row row1 = sheet.getRow(2);
		Cell cell = row.getCell(1);
		Cell cell1 = row1.getCell(1);
		//converting data to a single format number,spl char, char etc..
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		String data1 = format.formatCellValue(cell1);
		System.out.println(data);
		System.out.println(data1);
	}

}
