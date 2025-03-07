package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class proKabaddiScore {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
		//won match
		
		String wonMatchs = driver.findElement(By.xpath("//p[text()=\"Haryana Steelers\"]/ancestor::div[@class=\"row-head\"]//div[@class=\"table-data matches-won\"]")).getText();
		System.out.println("WonMatches="+wonMatchs);
		//lost match
		String lostMatchs = driver.findElement(By.xpath("//p[text()=\"Haryana Steelers\"]/ancestor::div[@class=\"row-head\"]//div[@class=\"table-data matches-lost\"]")).getText();
		System.out.println("LostMatchs="+lostMatchs);
		//no of pnts
		String totalPoints = driver.findElement(By.xpath("//p[text()=\"Haryana Steelers\"]/ancestor::div[@class=\"table-row-wrap\"]//div[@class=\"table-data points\"]")).getText();
		System.out.println("Total point= "+totalPoints);
	}

}
