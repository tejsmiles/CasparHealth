package PageObjects.Therapist;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Common.PageObject;


public class NewUserCredentialsPage  extends PageObject {

	@FindAll({@FindBy(xpath="//app-new-user-dialog//div[contains(@class,'mt-3')]/div/div")})
	List<WebElement> credentials;
	
	@FindBy(xpath="//app-new-user-dialog//button[@aria-label='Close dialog']")
	WebElement closePopUp;
	
	TherapistDashboardPage tdb;
	
	public NewUserCredentialsPage(WebDriver driver, WebDriverWait wait,TherapistDashboardPage tdb ) {
		super(driver, wait);
		this.tdb = tdb;
	}

	public boolean patientCredentialsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(this.credentials.get(0)));
		return false;
	}
	
	public String getNewUsername(){
		return  this.credentials.get(5).getText();
	}

	public String getNewPassword(){
		return  this.credentials.get(7).getText();
	}
	
	public TherapistDashboardPage credentialsClose() {
		this.closePopUp.click();
		return this.tdb;
	}
}
