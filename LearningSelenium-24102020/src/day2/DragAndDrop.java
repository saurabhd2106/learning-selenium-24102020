package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	WebDriver driver;

	String url = "https://test.qatechhub.com/drag-and-drop/";

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

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);

	}

	public void dragAndDrop() {
		WebElement source = driver.findElement(By.id("draggable"));

		WebElement target = driver.findElement(By.id("droppable"));
		
		String colorBeforeDnd = target.getCssValue("color");

		Actions action = new Actions(driver);

		//action.dragAndDrop(source, target).build().perform();

		action.moveToElement(source).clickAndHold(source).moveToElement(target).release(target).build().perform();
		
		String colorAfterDnd = target.getCssValue("color");
		
		System.out.println("Color before Drag and drop" + colorBeforeDnd);
		
		System.out.println("Color after Drag and drop" + colorAfterDnd);
	}

	public static void main(String[] args) {
		DragAndDrop dnd = new DragAndDrop();
		dnd.invokeBrowser("chrome");
		dnd.dragAndDrop();
	}

}
