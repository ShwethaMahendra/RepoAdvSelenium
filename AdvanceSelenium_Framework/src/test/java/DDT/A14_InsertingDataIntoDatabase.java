package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.mysql.jdbc.Driver;

public class A14_InsertingDataIntoDatabase {

	public static void main(String[] args) throws Throwable {
		//creating & registering driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//connecting to MySQL//google search for "mysql url for jdbc"/take ur database name in SQL(show databases;),"SQL uasername","password" 
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql/employeedata","root","MySQL");
		
		//create statement & query
	//	Statement state = connect.createStatement()="insert into employee(regno,firstname,lastname,address),values('3','Sharu','MM',)";
	}

}
