package testScenarios;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProductDetailsTest extends TestBase {
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	HomePage homePage;

	@Test(priority = 1, alwaysRun = true)
	public void LoggedInUserOpenItemPage() {
		homePage = new HomePage(driver);
		homePage.UserLogin(LoginEmail, LoginPass);
		homePage.SearchForItem(ItemName);
		driver.findElement(By.cssSelector("a[title = '" + ItemName + "']")).click();
	}

	@Test(dependsOnMethods = { "LoggedInUserOpenItemPage" })
	public void UserAddProductToCart() {
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectSize();
		productDetailsPage.AddProductToCart();
	}

	public void LoggedOUTUserOpenItemPage() {
		homePage = new HomePage(driver);
		homePage.SearchForItem(ItemName);
		driver.findElement(By.cssSelector("a[title = '" + ItemName + "']")).click();
	}
}
