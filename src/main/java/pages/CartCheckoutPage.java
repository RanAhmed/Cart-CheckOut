package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartCheckoutPage extends PageBase {

	public CartCheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "processAddress")
	WebElement addressProceedBtn;
	@FindBy(id = "cgv")
	WebElement shippingAgreementBtn;
	@FindBy(name = "processCarrier")
	WebElement shippingProceedBtn;
	@FindBy(css = "a[title = 'Pay by check.']")
	WebElement payCheckBtn;
	@FindBy(css = "button[class = 'button btn btn-default button-medium']")
	WebElement confirmOrderBtn;

	@FindBy(css = "a[title = 'Add']")
	WebElement addAddressBtn;
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
	@FindBy(id = "submitAddress")
	WebElement Register;
	@FindBy(id = "id_address_delivery")
	WebElement myAddressDDL;
	@FindBy(css = "p[class = 'alert alert-success']")
	public WebElement confirmOrdertMessage;

	public void ProceedAddressStage() {
		addressProceedBtn.click();
	}

	public void ProceedShippingStage() {
		shippingAgreementBtn.click();
		shippingProceedBtn.click();
	}

	public void ProceedPaymentStage() {
		payCheckBtn.click();
	}

	public void ProceedConfirmationStage() {
		confirmOrderBtn.click();
	}

	public void Addadress(String addressDetails, String cityName, String postalCode, String mobileNumber,
			String addressAlias) {
		addAddressBtn.click();
		Waittime();
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

	public void selectState() {
		Select stateSelection = new Select(state);
		stateSelection.selectByValue("10");
	}

	public void selectCountry() {
		Select countrySelection = new Select(country);
		countrySelection.selectByValue("21");
	}

	public void selectAddress() {
		Select countrySelection = new Select(myAddressDDL);
		int options = countrySelection.getOptions().size();
		countrySelection.selectByIndex(options - 1);
	}
}
