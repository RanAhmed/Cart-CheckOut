package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a[title = 'Delete']")
	WebElement deleteItemBtn;
	@FindBy(name = "quantity_1_5_0_464108")
	WebElement quantityTxt;
	@FindBy(id = "product_price_1_5_464108")
	public WebElement unitPrice;
	@FindBy(id = "total_product_price_1_5_464108")
	public WebElement totalprice;
	@FindBy(css = "a[title = 'Proceed to checkout']")
	List<WebElement> checkoutBtn;
	@FindBy(css = "p[class = 'alert alert-warning']")
	public WebElement emptyAlertMessage;

	public void RemoveProductFromCart() {
		deleteItemBtn.click();
	}

	public void UpdateProductQuantityInCart(String quantity) {
		quantityTxt.clear();
		quantityTxt.sendKeys(quantity);
	}

	public void openCheckoutPage() {
		checkoutBtn.get(1).click();
	}

}
