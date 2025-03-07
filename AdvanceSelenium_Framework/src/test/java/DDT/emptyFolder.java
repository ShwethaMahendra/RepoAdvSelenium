package DDT;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class emptyFolder {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele=driver.findElement(By.className("Pke_EE"));
		ele.sendKeys("iphone");
		ele.sendKeys(Keys.ENTER);
		
		List<WebElement> iPhoneList =driver.findElements(By.xpath("//div[contains(text(),'Apple iPhone')]"));
		
		for(WebElement list : iPhoneList) {
			
			System.out.println(list.getText());
			
		}
		
		
		}
		
		
		
	}


