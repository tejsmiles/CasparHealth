package PageObjects.Therapist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObjects.Common.PageObject;
import PageObjects.Login.LoginPage;

public class TherapistDashboardPage extends PageObject {

	@FindBy(linkText="Add Patient")
	WebElement buttonAddPatient;
	
	@FindBy(linkText="Sign out")
	WebElement menuSignout;
	
	public TherapistDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public NewPatientPage clickAddPatient() {
		this.buttonAddPatient.click();
		return new NewPatientPage(driver, this);
	}
	
	public LoginPage signout() {
		this.menuSignout.click();
		return new LoginPage(driver);
	}
	
}
