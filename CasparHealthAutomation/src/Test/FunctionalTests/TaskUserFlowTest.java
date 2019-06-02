package Test.FunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import PageObjects.Login.LoginPage;
import PageObjects.Therapist.NewPatientPage;
import PageObjects.Therapist.NewUserCredentialsPage;
import PageObjects.Therapist.TherapistDashboardPage;
import PageObjects.User.UserTermsPage;

public class TaskUserFlowTest extends FunctionalTest{

	String baseURL= "https://beta.caspar-health.com/en/#/user/sign_in";

	@Test
	public void userFlow() {

		//Step 1) Navigate to “ https://beta.caspar-health.com/en/#/user/sign_in ”
		driver.get(baseURL);

		assertEquals(driver.getCurrentUrl(), baseURL);

		//Step 2) Login with the following user credentials: Caspar ID: IXE0865 password: 78350619
		LoginPage loginPage = new LoginPage(driver, wait);

		assertTrue(loginPage.isDisplayed());

		loginPage.fillUserName("IXE0865");
		loginPage.fillPassword("78350619");
		TherapistDashboardPage therapistDB = loginPage.therapistLogin();

		assertTrue(therapistDB.isDisplayed());

		//Step 3) Click “Add patient” and create a new patient
		NewPatientPage newPatientPage = therapistDB.clickAddPatient();

		assertTrue(newPatientPage.isDisplayed());

		newPatientPage.fillFirstName("New");
		newPatientPage.fillLastName("Patient");
		newPatientPage.fillDOB("5", "January", "2006");
		newPatientPage.fillCountry("Germany");
		NewUserCredentialsPage newUserCredentialsPage = newPatientPage.newPatientSave();

		assertTrue(newUserCredentialsPage.patientCredentialsDisplayed());

		//Step 4) Use the login credentials of the patient
		
		String username = newUserCredentialsPage.getNewUsername();
		String password = newUserCredentialsPage.getNewPassword();
		
		//Close pop up
		therapistDB = newUserCredentialsPage.credentialsClose();

		
		//Step 5) Logout the user
		loginPage = therapistDB.signout();

		
		//Step 6) Login as the new patient on the same url like provided in step 1
		loginPage.fillUserName(username);
		loginPage.fillPassword(password);
		UserTermsPage userTermsPage = loginPage.userFirstLogin();

		//Step 7) Check that the t&c and release of medical information page is displayed. 

		assertTrue(userTermsPage.isTermsConditionsDisplayed());	

		assertTrue(userTermsPage.isReleaseOfMedicalInfoDisplayed());

	}
}
