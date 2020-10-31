package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FrameAndAlertHandling {

	WebDriver driver;

	String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert";

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

	public void handleAlertAndFrame() {
		driver.switchTo().frame("iframeResult");

		driver.findElement(By.xpath("//button[text() = 'Try it']")).click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());
		
		

		alert.accept();

		// Coming back to main page from a frame
		driver.switchTo().defaultContent();
	}

	public static void main(String[] args) {
		FrameAndAlertHandling fna = new FrameAndAlertHandling();

		fna.invokeBrowser("chrome");

		fna.handleAlertAndFrame();
	}

}
