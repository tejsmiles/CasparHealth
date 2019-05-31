package PageObjects.Therapist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObjects.Common.PageObject;

public class TherapistDashboardPage extends PageObject {

	@FindBy(linkText="Add Patient")
	WebElement buttonAddPatient;
	
	
	public TherapistDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public NewPatientPage clickAddPatient() {
		this.buttonAddPatient.click();
		return new NewPatientPage(driver);
	}
	
}
