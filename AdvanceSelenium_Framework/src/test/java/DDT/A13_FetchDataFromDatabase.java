package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthStyleFactory;

import com.mysql.cj.Query;
import com.mysql.jdbc.Driver;

public class A13_FetchDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		
		//step1 register driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2 :get connection to database //google search for URL as "mysql url for jdbc"/databasename ,username,password
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata", "root", "MySQL");

		//step3: create SQL statement
		Statement state = connect.createStatement();
		String Query = "Select* from employee";
		
		//step4: execute statement/query
		ResultSet result = state.executeQuery(Query);
		
		while (result.next()) {
			
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		
	}

}
