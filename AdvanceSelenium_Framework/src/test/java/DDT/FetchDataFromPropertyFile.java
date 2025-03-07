package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//fetching the path from out source 
		FileInputStream file = new FileInputStream("C:\\Shwetha\\Adv Selenium\\BrowserPropertyData.properties");
		
		//creating class or object to load data
		Properties pro = new Properties();
		//loading the data into pro class
		pro.load(file);
		String BROWSER = pro.getProperty("browser");
		
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		} else {

			driver=new ChromeDriver();
	}
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("userName");
		String PW = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(UN);
		driver.findElement(By.id("password")).sendKeys(PW);
		driver.findElement(By.id("login-button")).click();
		
		//inserting data to the file
		pro.setProperty("Browser1", "Firefox");
		pro.setProperty("UserName1", "Shwetha");
		pro.setProperty("Password1", "Shwe123");
		 FileOutputStream file1 = new FileOutputStream("C:\\Shwetha\\Adv Selenium\\BrowserPropertyData.properties");
		 pro.store(file1, "testdata");
	}
}
