package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MercuryTravelProject {

	WebDriver driver;

	String url = "https://www.mercurytravels.co.in/";

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

		driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();
	}

	public void defaultVerification() {
		driver.findElement(By.linkText("Flights")).click();
		
		driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();

		WebElement roundtripRadioButton = driver.findElement(By.xpath("//input[@value='R']"));

		if (roundtripRadioButton.isSelected()) {
			System.out.println("Default value is correct");

		} else {
			System.err.println("Fail");
		}
		
		WebElement dateOfReturn = driver.findElement(By.id("dpf2Cntr"));
		
		if(dateOfReturn.isDisplayed()) {
			System.out.println("Date of return is displayed");
		}
	}
	
	public static void main(String[] args) {
		MercuryTravelProject mtp = new MercuryTravelProject();
		
		mtp.invokeBrowser("chrome");
		
		mtp.defaultVerification();
	}

}
