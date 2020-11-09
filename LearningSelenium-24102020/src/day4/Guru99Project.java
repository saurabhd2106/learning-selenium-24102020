package day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import day2.WaitUtils;

@Listeners(TestListener.class)
public class Guru99Project {
	WebDriver driver;

	String url = "http://demo.guru99.com/v4/";

	@BeforeMethod
	public void invokeBrowser() {

		String browserType = "chrome";

		if (browserType.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SAURABH\\eclipse-workspace\\libs\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserType.equals("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\SAURABH\\eclipse-workspace\\libs\\msedgedriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);
	}

	@Test(dataProvider = "getData", dataProviderClass = TestDataSource.class)
	public void loginToApplication(String username, String password) {

		WebElement userId = driver.findElement(By.name("uid"));

		userId.sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

		WaitUtils.waitTillElementVisible(driver, 10, By.xpath("//td[starts-with(text(), 'Manger Id')]"));

		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(actualTitle, expectedTitle);

		System.out.println("I am here...");

		WebElement newCustomerLink = driver.findElement(By.linkText("New Customer"));

		softAssert.assertTrue(newCustomerLink.isDisplayed());

		softAssert.assertAll();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
