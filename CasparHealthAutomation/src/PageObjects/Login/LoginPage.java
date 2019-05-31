package PageObjects.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Common.PageObject;
import PageObjects.Therapist.TherapistDashboardPage;
import PageObjects.User.UserTermsPage;

public class LoginPage extends PageObject {

	//Username: mat-input-0
	@FindBy(id="mat-input-0")
	WebElement inputUserName;
	
	//Password: mat-input-1
	@FindBy(id="mat-input-1")
	WebElement inputPassword;
	
	@FindBy(xpath="//form//button[contains(@class, 'login')]")
	WebElement buttonLogin;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void fillUserName(String userName) {
		this.inputUserName.clear();
		this.inputUserName.sendKeys(userName);
	}
	
	public void fillPassword(String password) {
		this.inputPassword.clear();
		this.inputPassword.sendKeys(password);
	}

	public boolean isDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(this.inputUserName));
		return this.inputUserName.isDisplayed();
	}
	
	public UserTermsPage userFirstLogin() {
		this.buttonLogin.click();
		return new UserTermsPage(driver, wait);
	}
	
	public TherapistDashboardPage therapistLogin() {
		this.buttonLogin.click();
		return new TherapistDashboardPage(driver, wait);
	}
	
}
