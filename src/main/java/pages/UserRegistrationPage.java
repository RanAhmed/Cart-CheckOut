package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "id_gender2")
	WebElement Titlefemale;
	@FindBy(id = "customer_firstname")
	WebElement FirstName;
	@FindBy(id = "customer_lastname")
	WebElement LastName;
	@FindBy(id = "passwd")
	WebElement Password;
	@FindBy(id = "days")
	WebElement birhtDateDay;
	@FindBy(id = "months")
	WebElement birhtDateMonth;
	@FindBy(id = "years")
	WebElement birhtDateYear;
	@FindBy(id = "address1")
	WebElement address;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "id_state")
	WebElement state;
	@FindBy(id = "postcode")
	WebElement postCode;
	@FindBy(id = "id_country")
	WebElement country;
	@FindBy(id = "phone_mobile")
	WebElement phoneMobile;
	@FindBy(id = "alias")
	WebElement alias;
	@FindBy(id = "submitAccount")
	WebElement Register;

	public void UserRegistration(String firstname, String lastname, String password, String addressDetails,
			String cityName, String postalCode, String mobileNumber, String addressAlias) {
		Waittime();
		Titlefemale.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Password.sendKeys(password);
		selectBirthDate();
		address.sendKeys(addressDetails);
		city.sendKeys(cityName);
		selectState();
		postCode.sendKeys(postalCode);
		selectCountry();
		phoneMobile.sendKeys(mobileNumber);
		alias.clear();
		alias.sendKeys(addressAlias);
		Register.click();
	}

	public void selectBirthDate() {
		Select day = new Select(birhtDateDay);
		day.selectByValue("31");
		Select month = new Select(birhtDateMonth);
		month.selectByValue("3");
		Select year = new Select(birhtDateYear);
		year.selectByValue("1990");
	}

	public void selectState() {
		Select stateSelection = new Select(state);
		stateSelection.selectByValue("10");
	}

	public void selectCountry() {
		Select countrySelection = new Select(country);
		countrySelection.selectByValue("21");
	}
}
