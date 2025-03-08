import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class A14_InsertDataIntoDatabase1 {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata", "root", "MySQL");
		
		Statement state = connect.createStatement();
		String query = "insert into employee(regno,firstname,lastname,address)values('4','sharu','MM','Mysore')";
		
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data inserted sucessfully");
		}
		else
			System.out.println("data not inserted");

	}

}
