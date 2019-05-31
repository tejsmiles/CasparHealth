package Test.FunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObjects.Login.LoginPage;
import PageObjects.Therapist.NewPatientPage;
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
		therapistDB = newPatientPage.newPatientSave();

		assertTrue(therapistDB.patientCredentialsDisplayed());

		//Step 4) Use the login credentials of the patient

		//TODO extract username and password
		String username = "", password = ""	;
		//TODO close pop up

		System.out.println("4: " + driver.getCurrentUrl());
		//Step 5) Logout the user
		loginPage = therapistDB.signout();

		System.out.println("5: " + driver.getCurrentUrl());
		//Step 6) Login as the new patient on the same url like provided in step 1
		loginPage.fillUserName(username);
		loginPage.fillPassword(password);
		UserTermsPage userTermsPage = loginPage.userFirstLogin();

		System.out.println("6: " + driver.getCurrentUrl());
		//Step 7) Check that the t&c and release of medical information page is displayed. 

		assertTrue(userTermsPage.isTermsConditionsDisplayed());	

		assertTrue(userTermsPage.isReleaseOfMedicalInfoDisplayed());

	}
}
