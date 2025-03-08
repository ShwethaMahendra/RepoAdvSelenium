package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class A7_JasonDDT {

	public static void main(String[] args) throws Throwable {
		
		File file = new File("./src/test/resources/Data.Json");
		
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		
		//.get(String fieldname)
		String BROWSER = data.get("browser").asText();
		String URL = data.get("url").asText();
		String UN = data.get("userName").asText();
		String PW = data.get("password").asText();
		
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			
			driver=new ChromeDriver();
		}
			else if (BROWSER.equalsIgnoreCase("Firefox")) {
			
			driver=new FirefoxDriver();
		}
		//default browser incase above given browser is not available in system 
		//like edge then as default it will open in chrome
			else {
				driver=new ChromeDriver();
			}
		
			driver.get(URL);
			driver.findElement(By.id("user-name")).sendKeys(UN);
			driver.findElement(By.id("password")).sendKeys(PW);
			driver.findElement(By.id("login-button")).click();
			
			
			
	}

}
