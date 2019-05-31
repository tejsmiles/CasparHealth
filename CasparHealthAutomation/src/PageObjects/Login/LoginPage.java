package PageObjects.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObjects.Common.PageObject;
import PageObjects.Therapist.TherapistDashboardPage;
import PageObjects.User.UserDashboardPage;
import PageObjects.User.UserTermsPage;

public class LoginPage extends PageObject {

	//Username: mat-input-0
	@FindBy(id="mat-input-0")
	WebElement inputUserName;
	
	//Password: mat-input-1
	@FindBy(id="mat-input-1")
	WebElement inputPassword;
	
	@FindBy(linkText="LOGIN")
	WebElement buttonLogin;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void fillUserName(String userName) {
		this.inputUserName.clear();
		this.inputUserName.sendKeys(userName);
	}
	
	public void fillPassword(String password) {
		this.inputPassword.clear();
		this.inputPassword.sendKeys(password);
	}
	
	public UserDashboardPage userLogin() {
		this.buttonLogin.click();
		return new UserDashboardPage(driver);
	}
	
	public UserTermsPage userFirstLogin() {
		this.buttonLogin.click();
		return new UserTermsPage(driver);
	}
	
	public TherapistDashboardPage therapistLogin() {
		this.buttonLogin.click();
		return new TherapistDashboardPage(driver);
	}
	
}
