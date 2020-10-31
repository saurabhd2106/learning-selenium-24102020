package day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {

	WebDriver driver;

	String url = "http://demo.guru99.com/v4/";

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

	public String getTitle() {
		return driver.getTitle();
	}

	public void loginToApplication(String username, String password) {

		WebElement userId = driver.findElement(By.name("uid"));

		userId.sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

	}

	public void addCustomer() {
		driver.findElement(By.linkText("New Customer")).click();

		driver.findElement(By.name("name")).sendKeys("Prerna");

		driver.findElement(By.xpath("//input[@value='f']")).click();

		String emailId = "ss" + System.currentTimeMillis() + "@gmail.com";

		driver.findElement(By.id("dob")).sendKeys("22-10-2000");
		driver.findElement(By.name("addr")).sendKeys("Gaur City");
		driver.findElement(By.name("emailid")).sendKeys(emailId);
		driver.findElement(By.name("password")).sendKeys("abcde");
		driver.findElement(By.name("city")).sendKeys("noida");
		driver.findElement(By.name("state")).sendKeys("UP");
		driver.findElement(By.name("pinno")).sendKeys("201301");
		driver.findElement(By.name("telephoneno")).sendKeys("0120345678");
		driver.findElement(By.name("sub")).click();

	}

	public String getCustomerId() {
		return driver.findElement(By.xpath("//table[@id='customer']//td[text()='Customer ID']//following-sibling::td"))
				.getText();
	}

	public void addAccount(String customerId) {
		driver.findElement(By.linkText("New Account")).click();

		driver.findElement(By.name("cusid")).sendKeys(customerId);

		WebElement selDropdown = driver.findElement(By.name("selaccount"));

		Select select = new Select(selDropdown);

		System.out.println(select.isMultiple());

		select.selectByVisibleText("Current");

		driver.findElement(By.name("inideposit")).sendKeys("387429");

		driver.findElement(By.name("button2")).click();
	}

	public void logOut() {

		Actions action = new Actions(driver);

		WebElement logOutLink = driver.findElement(By.linkText("Log out"));

		action.moveToElement(logOutLink).click().build().perform();

		

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		// alert.dismiss();

		System.out.println();
	}

	public void closeBrowser() {

		// Closes the current active window/tab
		// driver.close();

		// Close all the windows which are opened by Selenium session
		driver.quit();
	}

}
