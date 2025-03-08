package POM_Prop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

public class OrgLookUpImg {
	
	public OrgLookUpImg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement lookUpImg;

	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	//businesslogic
	public void ClickOnOrgLookUpImg() {
		lookUpImg.click();
	}
	
}
