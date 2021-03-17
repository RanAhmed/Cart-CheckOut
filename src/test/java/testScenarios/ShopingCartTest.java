
package testScenarios;

import pages.HomePage;
import pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopingCartTest extends TestBase {
	ProductDetailsTest productDetailsTest;
	ShoppingCartPage shoppingCartPage;
	HomePage homePage;

	@Test(priority = 1, alwaysRun = true)
	public void UserAddProductToCart() {
		productDetailsTest = new ProductDetailsTest();
		productDetailsTest.LoggedInUserOpenItemPage();
		productDetailsTest.UserAddProductToCart();
	}

	@Test(dependsOnMethods = { "UserAddProductToCart" })
	public void UpdateProductQuantity() {
		shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.UpdateProductQuantityInCart("3");
		homePage = new HomePage(driver);
		homePage.Waittime();
		Assert.assertTrue(shoppingCartPage.totalprice.getText().contains("49.53"));
	}

	@Test(dependsOnMethods = { "UpdateProductQuantity" })
	public void UserRemoveProductFromCart() {
		shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.RemoveProductFromCart();
		homePage = new HomePage(driver);
		homePage.Waittime();
		Assert.assertTrue(shoppingCartPage.emptyAlertMessage.getText().contains("Your shopping cart is empty."));
	}
}
