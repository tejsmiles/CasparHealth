package Test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import PageObjects.Login.LoginPage;
import PageObjects.Therapist.NewPatientPage;
import PageObjects.Therapist.TherapistDashboardPage;
import PageObjects.User.UserTermsPage;

public class taskUserFlow {
	WebDriver driver;
	String baseURL="https://beta.caspar-health.com/en/#/user/sign_in ";
	
	public void userFlow() {
		//Step 1) Navigate to “ https://beta.caspar-health.com/en/#/user/sign_in ”
		driver.get(baseURL);
		
		//Step 2) Login with the following user credentials: Caspar ID: IXE0865 password: 78350619
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isDisplayed("Casper"));
		loginPage.fillUserName("IXE0865");
		loginPage.fillPassword("78350619");
		TherapistDashboardPage therapistDB = loginPage.therapistLogin();

		//Step 3) Click “Add patient” and create a new patient
		NewPatientPage newPatientPage = therapistDB.clickAddPatient();
		newPatientPage.fillFirstName("New");
		newPatientPage.fillLastName("Patient");
		newPatientPage.fillDOB("5", "January", "2006");
		newPatientPage.fillCountry("Germany");
		therapistDB = newPatientPage.newPatientSave();
		
		//Step 4) Use the login credentials of the patient
		
			//TODO extract username and password
			String username = null, password = null;
			//TODO close pop up
		
		//Step 5) Logout the user
		loginPage = therapistDB.signout();
		
		//Step 6) Login as the new patient on the same url like provided in step 1
		loginPage.fillUserName(username);
		loginPage.fillPassword(password);
		UserTermsPage userTermsPage = loginPage.userFirstLogin();
		
		//Step 7) Check that the t&c and release of medical information page is displayed. 
			//TODO check t&c
			//TODO check rmi
	}
}
