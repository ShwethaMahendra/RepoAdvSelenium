package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campLink;
	
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getProdLink() {
		return prodLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//businessLogic
	public void ClickOrgLink() {
		orgLink.click();
	}
	public void ClickMoreLink() {
		moreLink.click();
	}
	public void ClickCampLink() {
		moreLink.click();
		campLink.click();
	}
	public void ClickProdLink() {
		prodLink.click();
	}
	public void logOut() {
			adminLink.click();
			signOutLink.click();	
		}
		
}
