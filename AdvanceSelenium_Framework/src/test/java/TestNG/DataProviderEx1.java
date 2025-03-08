package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//executing same method multiple times with different set of data is called data provider
public class DataProviderEx1 {
	
	@Test(dataProvider = "getData")
	
	public void bookTicket(String src, String destination, int noOfPpl) {
		
		System.out.println("Book tickets from "+src+" to "+destination+ " for " +noOfPpl+" passangers");
	}
	//[][]=2D object array
	@DataProvider
	public Object[][] getData(){
		
		Object[][] objArr = new Object[3][3];//3 set of data, 3 rows
		objArr[0][0]="Goa";
		objArr[0][1]="Bangalore";
		objArr[0][2]=2;
		
		objArr[1][0]="Goa";
		objArr[1][1]="Mangalore";
		objArr[1][2]=3;
		
		objArr[2][0]="Goa";
		objArr[2][1]="Mysuru";
		objArr[2][2]=4;
		return objArr;
				
		
		
	}
}
