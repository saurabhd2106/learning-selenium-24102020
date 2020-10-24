package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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

		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void loginToApplication(String username, String password) {
		
		WebElement userId =	driver.findElement(By.name("uid"));
		
		userId.sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	public void addCustomer() {
		driver.findElement(By.linkText("New Customer")).click();
		
		driver.findElement(By.name("name")).sendKeys("Prerna");
		
		driver.findElement(By.xpath("//input[@value='f']")).click();
		
		String emailId = "ss" + System.currentTimeMillis() + "@gmail.com"; 
	}

	public void closeBrowser() {

		// Closes the current active window/tab
		// driver.close();

		// Close all the windows which are opened by Selenium session
		driver.quit();
	}

}
