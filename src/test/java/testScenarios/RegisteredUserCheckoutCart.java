package testScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartCheckoutPage;
import pages.HomePage;
import pages.ShoppingCartPage;

public class RegisteredUserCheckoutCart extends TestBase {
	HomePage homePage;
	ProductDetailsTest productDetailsTest;
	CartCheckoutPage cartCheckoutPage;
	ShoppingCartPage shoppingCartPage;
	ShopingCartTest shopingCartTest;
	String randomNum;

	// User login then select item for car
	@Test(priority = 1, alwaysRun = true)
	public void LoggedInUserCheckoutHisCart() {
		homePage = new HomePage(driver);
		// User login, search for item and add it to cart
		shopingCartTest = new ShopingCartTest();
		shopingCartTest.UserAddProductToCart();
		shopingCartTest.UpdateProductQuantity();

		// Proceed to checkout the cart
		shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.openCheckoutPage();

		// Confirm the order after changing the shipping address
		cartCheckoutPage = new CartCheckoutPage(driver);
		randomNum = CreateRandomNum();
		// add new address and select it from my address DDL then proceed
		cartCheckoutPage.Addadress("3/12 Nasr ST.", "Maadi", "01234", "01099255159",
				"My Home Address" + randomNum + ".");
		cartCheckoutPage.selectAddress();
		homePage.Waittime();
		cartCheckoutPage.ProceedAddressStage();
		// proceed shipping stage
		cartCheckoutPage.ProceedShippingStage();
		// proceed payment and confirm order
		cartCheckoutPage.ProceedPaymentStage();
		cartCheckoutPage.ProceedConfirmationStage();
		homePage.Waittime();
		Assert.assertTrue(
				cartCheckoutPage.confirmOrdertMessage.getText().contains("Your order on My Store is complete."));

		// Logout after place order
		homePage.logOut();
	}

	// User select item for cart without login
	@Test(dependsOnMethods = { "LoggedInUserCheckoutHisCart" })
	public void LoggedOutUserCheckoutHisCart() {
		homePage = new HomePage(driver);
		// User (Not Logged in) search for item and add it to cart
		productDetailsTest = new ProductDetailsTest();
		productDetailsTest.LoggedOUTUserOpenItemPage();
		productDetailsTest.UserAddProductToCart();

		// Proceed to checkout the cart
		shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.openCheckoutPage();

		// Sign in
		homePage.UserLogin(LoginEmail, LoginPass);

		// Open the cart
		homePage.ViewCartDetailsFromHome();
		shoppingCartPage.openCheckoutPage();

		// Confirm address
		cartCheckoutPage = new CartCheckoutPage(driver);
		cartCheckoutPage.ProceedAddressStage();
		// proceed shipping stage
		cartCheckoutPage.ProceedShippingStage();
		// proceed payment and confirm order
		cartCheckoutPage.ProceedPaymentStage();
		cartCheckoutPage.ProceedConfirmationStage();
		homePage.Waittime();
		Assert.assertTrue(
				cartCheckoutPage.confirmOrdertMessage.getText().contains("Your order on My Store is complete."));

		// Logout after place order
		homePage.logOut();
	}
}
