package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Prop.FlipkartEx;

public class FlipkartEx_FindysAndFindAll {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		FlipkartEx search = new FlipkartEx(driver);
		search.searchProd("bags");
	}

}
