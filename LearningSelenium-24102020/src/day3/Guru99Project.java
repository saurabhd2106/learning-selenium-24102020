package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99Project {
	WebDriver driver;

	String url = "http://demo.guru99.com/v4/";

	@Parameters("browserType")
	@BeforeClass
	public void invokeBrowser(String browserType) {

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

	@Parameters({ "userId", "userPass" })
	@Test
	public void loginToApplication(String username, String password) {

		WebElement userId = driver.findElement(By.name("uid"));

		userId.sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
