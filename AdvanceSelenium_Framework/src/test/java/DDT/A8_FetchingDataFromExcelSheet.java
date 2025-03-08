package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class A8_FetchingDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		//Sep1: connecting the excel file
		FileInputStream file = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		
		//step2 : keep excel read mode
		Workbook book = WorkbookFactory.create(file);
		
		////Step3: navigate to excel sheet
		Sheet sheet = book.getSheet("sheet1");
		
		//Step4:navigate into row
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		//System.out.println(cell.getStringCellValue());
		String exceldata = cell.getStringCellValue();
		System.out.println(exceldata);
		
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(1);
		cell1.setCellValue("Rakesh");
		
		FileOutputStream file1 = new FileOutputStream("./src/test/resources/ExcelData.xlsx");
		book.write(file1);
		
	}

}
