package testScenarios;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	HomePage homePage;
	UserRegistrationPage userRegistrationPage;

	@Test(priority = 1, alwaysRun = true)
	public void UserRegister() {
		homePage = new HomePage(driver);
		homePage.OpenRegistrationPage(emailaddress);
		userRegistrationPage = new UserRegistrationPage(driver);
		userRegistrationPage.UserRegistration("Rana", "Ahmed", "Password@12345", "Elgazaer Street", "New Maadi",
				"21251", "01099255159", "Adrees Alias Test");
	}

	@Test(dependsOnMethods = { "UserRegister" })
	public void RegisteredUserLogout() {
		homePage = new HomePage(driver);
		homePage.logOut();
	}

	@Test(dependsOnMethods = { "RegisteredUserLogout" })
	public void RegisteredUserLogin() {
		homePage = new HomePage(driver);
		homePage.UserLogin(emailaddress, "Password@12345");
	}
}
