package DDT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_bigBasket {

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("(//input[@placeholder=\"Search for Products...\"])[2]")).sendKeys("apple");
		
		List<WebElement> list=driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU']"));
		int size = list.size();
		System.out.println(size);
		
		Actions a=new Actions(driver);
		
		for (WebElement ele : list) {
			String apple = ele.getText();
			System.out.println(apple);
		
			
			if (ele.getText().equals("Baby Apple Shimla")) {
				
				
//				WebElement ele1=driver.findElement(By.xpath("(//ul[@class=\"overscroll-contain\"]/li//div[@class=\"flex-1 flex items-center mr-2.5 overflow-hidden\"])[3]"));
//				a.moveToElement(ele1).click().perform();
				ele.click();
				break;
			}
			}
		
		
		
		WebElement search = driver.findElement(By.xpath("//div[@class=\"Header___StyledQuickSearch2-sc-19kl9m3-0 gzbZOD\"]"));
		a.moveToElement(search).click().perform();
		
		String name=driver.findElement(By.xpath("//h1[@class=\"Description___StyledH-sc-82a36a-2 bofYPK\"]")).getText();
		System.out.println("Apple Name : "+name);
		String price = driver.findElement(By.xpath("//h1[@class=\"Description___StyledH-sc-82a36a-2 bofYPK\"]/..//td[@class=\"Description___StyledTd-sc-82a36a-4 fLZywG\"]")).getText();
		System.out.println("Apple Price : "+price);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		driver.findElement(By.xpath("//button[@class=\"Button-sc-1dr2sn8-0 PdCartCTA___StyledButton2-sc-mq73zq-3 kYQsWi bwKrKT group false group false\"]")).click();
		Thread.sleep(3000);
		WebElement addedqty = driver.findElement(By.xpath("//div[@class=\"PdCartCTA___StyledDiv2-sc-mq73zq-2 cRtFqL\"]"));
		System.out.println(addedqty.getText()+" qty added into basket");
	}
		
		
	}	
		
	
