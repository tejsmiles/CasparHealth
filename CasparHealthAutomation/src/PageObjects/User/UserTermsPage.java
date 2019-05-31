package PageObjects.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Common.PageObject;

public class UserTermsPage extends PageObject {

	@FindBy(xpath="//app-terms-of-service")
	WebElement tnc;
	
	@FindBy(xpath="")
	WebElement rmi;
	
	public UserTermsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public boolean isTermsConditionsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(this.tnc));
		return this.tnc.isDisplayed();
	}
	
	public boolean isReleaseOfMedicalInfoDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(this.rmi));
		return this.rmi.isDisplayed();
	}
	
}
