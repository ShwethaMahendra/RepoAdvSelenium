package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageEx {
	//initilization through constructor
	public LoginPageEx(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	// Declaration
	@FindBy(name="user_name")
	private WebElement userTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordField;
	
	@FindBy	(id="submitButton")
	private WebElement loginButton;

	//getter methods
	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	//businessLogic
	/**
	 * This method is used to login the application
	 */
	public void loginToApp(String username, String password) {
		userTextField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
}
