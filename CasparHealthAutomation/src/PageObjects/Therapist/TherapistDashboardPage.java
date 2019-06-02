package PageObjects.Therapist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Common.PageObject;
import PageObjects.Login.LoginPage;

public class TherapistDashboardPage extends PageObject {

	@FindBy(xpath="//button[contains(text(), 'Add Patient')]")
	WebElement buttonAddPatient;
	
	@FindBy(xpath="//div[contains(text(),'Sign out')]")
	WebElement menuSignout;
	
	public TherapistDashboardPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public boolean isDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(this.buttonAddPatient));
		return this.buttonAddPatient.isDisplayed();
	}
	
	public NewPatientPage clickAddPatient() {
		this.buttonAddPatient.click();
		return new NewPatientPage(driver,wait, this);
	}
	
	public LoginPage signout() {
		this.menuSignout.click();
		return new LoginPage(driver, wait);
	}


}
