package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "login")
	WebElement signIn;
	@FindBy(id = "email_create")
	WebElement emailAddress;
	@FindBy(id = "SubmitCreate")
	WebElement register;
	@FindBy(className = "logout")
	WebElement logOut;
	@FindBy(id = "email")
	WebElement loginEmail;
	@FindBy(id = "passwd")
	WebElement loginPassword;
	@FindBy(id = "SubmitLogin")
	WebElement loginButton;
	@FindBy(id = "search_query_top")
	WebElement SearchTxt;
	@FindBy(css = "a[title = 'View my shopping cart']")
	WebElement ViewCartBtn;

	public void OpenRegistrationPage(String emailAdd) {
		signIn.click();
		emailAddress.sendKeys(emailAdd);
		register.click();
	}

	public void logOut() {
		Waittime();
		logOut.click();
		Waittime();
	}

	public void OpenLoginPage() {
		signIn.click();
	}

	public void UserLogin(String email, String password) {
		signIn.click();
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginButton.click();
		Waittime();
	}

	public void SearchForItem(String itemName) {
		SearchTxt.clear();
		SearchTxt.sendKeys(itemName);
		SearchTxt.sendKeys(Keys.ENTER);
	}

	public void ViewCartDetailsFromHome() {
		ViewCartBtn.click();
	}
}
