package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertyFile {

	public static void main(String[] args) throws Throwable {
	
		//FileInputStream file = new FileInputStream("./src/test/resources/BrowserPropertyData.properties");
		FileInputStream file=new FileInputStream("C:\\Shwetha\\Adv Selenium\\BrowserPropertyData.properties");
		//keeping property in read mode
		Properties pro=new Properties();
		
		pro.setProperty("browser", "chorme");
		pro.setProperty("url", "https://www.flipkart.com");
		
		//FileOutputStream file1 = new FileOutputStream("./src/test/resources/BrowserPropertyData.properties");
		FileOutputStream file1= new FileOutputStream("C:\\Shwetha\\Adv Selenium\\BrowserPropertyData.properties");
		pro.store(file1, "Overwritting data");
		
//---------------------------------------------------------------------------------------------------
		
		//to read the inserted data//fileinput is read mode
		FileInputStream file2 = new FileInputStream("C:\\\\Shwetha\\\\Adv Selenium\\\\BrowserPropertyData.properties");
		pro.load(file2);
		
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		} else {

			driver=new ChromeDriver();
	}
		
		driver.get(URL);

		
	}

}
