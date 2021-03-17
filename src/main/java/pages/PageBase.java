package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public Actions action;

	public void Waittime() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("got interrupted!");
		}
	}

	public void ScrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
		// element);
		// jse.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("scrollBy(0,2500)");
	}

	public void HoverOverElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
}
