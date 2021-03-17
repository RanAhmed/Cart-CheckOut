package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "add_to_cart")
	WebElement AddToCartBtn;
	@FindBy(id = "group_1")
	WebElement SizeDDL;
	@FindBy(css = "a[title = 'Proceed to checkout']")
	WebElement ProceedBtn;

	public void AddProductToCart() {
		AddToCartBtn.click();
		Waittime();
		ProceedBtn.click();
	}

	public void selectSize() {
		Select sizeSelection = new Select(SizeDDL);
		sizeSelection.selectByValue("3");
	}
}
