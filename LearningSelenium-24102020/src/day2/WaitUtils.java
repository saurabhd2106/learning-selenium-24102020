package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static void waitTillElementVisible(WebDriver driver, int timeoutInSeconds, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static void waitTillElementIsClickable(WebDriver driver, int timeoutInSeconds, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static void waitTillAlertIsPresent(WebDriver driver, int timeoutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void waitTillElementVisibleViaFluent(WebDriver driver, int pollingTime, int timeoutInSeconds,
			By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
		
	}

	
}
