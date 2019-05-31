package Test.FunctionalTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {

		static WebDriver driver;
		
		@BeforeClass
		public static void setUp() {
			System.setProperty("webdriver.chrome.driver","/Users/tejaswinee/myProjects/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}
		
		@AfterClass
		public static void tearDown() {
			driver.close();
		}
		
		@After
		public void cleanUp() {
			driver.manage().deleteAllCookies();
	
		}
}
