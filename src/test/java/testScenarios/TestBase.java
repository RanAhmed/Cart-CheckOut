package testScenarios;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//import java.time.Duration;

public class TestBase {

	public static WebDriver driver;
	public String LoginEmail = "eng_rana.ahmed@hotmail.com";
	public String LoginPass = "Password@12345";
	public String ItemName = "Faded Short Sleeve T-shirts";
	public static String emailaddress;

	@BeforeSuite
	public void StartDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String randomNum = CreateRandomNum();
		emailaddress = "rana.ahmed" + randomNum + "@hotmail.com";
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	public String CreateRandomNum() {
		int rand;
		rand = (int) (Math.random() * (1000 - 1 + 1) + 1);
		return Integer.toString(rand);
	}

	@AfterSuite
	public void StopDriver() {
		driver.close();
		driver.quit();
	}
}
