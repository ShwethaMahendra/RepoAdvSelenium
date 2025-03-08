package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriver_Utility {
	/**
	 * this method is used to maximize the window
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {
		
	driver.manage().window().maximize();
	}
	/**
	 * this method is used to wait for all the element to get loaded
	 * @param driver
	 */
	
	public void loadTheElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void windowSwitching(WebDriver driver, String partialTitle) {
		
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> itr = allWin.iterator();
		
		while (itr.hasNext()) {
			String win = itr.next();
			driver.switchTo().window(win);
			
			if (win.contains(partialTitle)) {
				break;
			}
		}
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
