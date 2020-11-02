package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandleExample {

	WebDriver driver;

	String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open";

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

	public void handleMultipleWindow() {

		String parentWindow = driver.getWindowHandle();

		System.out.println("Parent Session Id/ Window Handle" + parentWindow);

		driver.switchTo().frame("iframeResult");

		driver.findElement(By.xpath("//button[text() = 'Try it']")).click();

		String childWindow = driver.getWindowHandles().toArray()[1].toString();

		driver.switchTo().window(childWindow);

		System.out.println(driver.getTitle());

		driver.close();

		driver.switchTo().window(parentWindow);

		System.out.println(driver.getTitle());

		driver.quit();

	}

	public static void main(String[] args) {
		WindowHandleExample fna = new WindowHandleExample();

		fna.invokeBrowser("chrome");

		fna.handleMultipleWindow();

	}

}
