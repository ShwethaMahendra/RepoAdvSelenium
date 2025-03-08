package DDT;

import java.security.KeyPairGeneratorSpi;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_amazon_iteratePhoneColour {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		
		
		List<WebElement> iPhoneColor=driver.findElements(By.xpath("//span[text()=\"Apple iPhone 15 (128 GB) - Pink\"]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class=\"a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view\"]//a"));
		
		System.out.println("Available iPhone Colors:");
		
		for (WebElement color : iPhoneColor) {
			
			
			System.out.println(color.getAttribute("aria-label"));
			
		}
		
		
				
		
	}

}
