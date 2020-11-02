package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	WebDriver driver;

	String url = "https://flipkart.com";

	public void invokeBrowser(String browserType) {

		if (browserType.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SAURABH\\eclipse-workspace\\libs\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserType.equals("chrome-headless")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SAURABH\\eclipse-workspace\\libs\\chromedriver.exe");

			ChromeOptions chrOptions = new ChromeOptions();

			chrOptions.addArguments("--headless");

			driver = new ChromeDriver(chrOptions);

		}

		else if (browserType.equals("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\SAURABH\\eclipse-workspace\\libs\\msedgedriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);

		driver.findElement(By.xpath("//div[@class='_3Njdz7']/button")).click();
	}

	public void mouseHoverExample() {

		WebElement electronicsLink = driver.findElement(By.xpath("//span[text()='Electronics']"));

		Actions action = new Actions(driver);

		action.moveToElement(electronicsLink).build().perform();

		By samsungLinkLocator = By.linkText("Samsung");

		WaitUtils.waitTillElementVisibleViaFluent(driver, 250, 10, samsungLinkLocator);

		WebElement samsungLink = driver.findElement(samsungLinkLocator);

		action.moveToElement(samsungLink).click(samsungLink).build().perform();

	}

	public static void main(String[] args) {
		Flipkart flipkart = new Flipkart();

		flipkart.invokeBrowser("chrome-headless");

		flipkart.mouseHoverExample();

	}

}
