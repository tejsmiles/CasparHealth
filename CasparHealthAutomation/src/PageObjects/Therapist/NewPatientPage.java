package PageObjects.Therapist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Common.PageObject;

public class NewPatientPage extends PageObject {

	//First Name: mat-input-26 
	@FindBy(id="mat-input-7")
	WebElement inputFirstName;

	//Last Name: mat-input-27 
	@FindBy(id="mat-input-8")
	WebElement inputLastName;

	//Day: mat-select-5
	@FindBy(id="mat-select-1")
	WebElement selectDay;

	//Month: mat-select-6
	@FindBy(id="mat-select-2")
	WebElement selectMonth;

	//Year: mat-select-7
	@FindBy(id="mat-select-3")
	WebElement selectYear;

	//Country: mat-select-8
	@FindBy(id="mat-select-4")
	WebElement selectCountry;

	@FindBy(xpath="//button[contains(text(), 'SAVE')]")
	WebElement buttonSave;
	TherapistDashboardPage therapistDB;

	public NewPatientPage(WebDriver driver, WebDriverWait wait, TherapistDashboardPage therapistDB) {
		super(driver, wait);
		this.therapistDB = therapistDB;
	}


	public void fillFirstName(String firstname) {
		this.inputFirstName.clear();
		this.inputFirstName.sendKeys(firstname);
	}

	public void fillLastName(String lastname) {
		this.inputLastName.clear();
		this.inputLastName.sendKeys(lastname);
	}
	
	public void fillDOB(String day, String month, String year) {
		this.selectDay.sendKeys(day);
		this.selectMonth.sendKeys(month);
		this.selectYear.sendKeys(year);
	}
	
	public void fillCountry(String country) {
		this.selectCountry.sendKeys(country);
	}
	
	public NewUserCredentialsPage newPatientSave() throws InterruptedException {
		Thread.sleep(1000);
		this.buttonSave.click();
		return new NewUserCredentialsPage(driver, wait, this.therapistDB);
	}


	public boolean isDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(this.inputFirstName));
		return this.inputFirstName.isDisplayed();
	}

}
