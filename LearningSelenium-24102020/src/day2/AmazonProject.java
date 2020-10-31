package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonProject {
	WebDriver driver;

	String url = "https://amazon.in";

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
	
	public void getAllLinksAndUrl() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for(WebElement link : allLinks) {
			System.out.println("Link Text - "+ link.getText());
			
			System.out.println("URL - "+ link.getAttribute("href"));
			
			System.out.println("------------------------------------------");
		}
	}

	public void searchProduct(String product, String category) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);

		WebElement selDropdown = driver.findElement(By.id("searchDropdownBox"));

		Select selCategory = new Select(selDropdown);

		selCategory.selectByVisibleText(category);

		driver.findElement(By.xpath("//input[@value='Go']")).click();

	}

	public String getNthProduct(int productNumber) {

		// String xpathExample = "//div[@data-component-type='s-search-result' and
		// @data-index='"+ productNumber +"']";

		String xpathExpression = String.format("//div[@data-component-type='s-search-result' and @data-index='%d']",
				productNumber);

		return driver.findElement(By.xpath(xpathExpression)).getText();
	}

	public void getAllProducts() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

		for (WebElement product : allProducts) {
			System.out.println(product.getText());

			System.out.println("-----------------------------------");
		}
	}

	public void getAllProductsViaScrollDownUsingActionsClass() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

		Actions action = new Actions(driver);

		for (WebElement product : allProducts) {

			action.moveToElement(product).build().perform();

			System.out.println(product.getText());

			System.out.println("-----------------------------------");
		}
	}

	public void getAllProductsViaScrollDownUsingJS() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

		int xCordinate;
		int yCordinate;

		for (WebElement product : allProducts) {

			xCordinate = product.getLocation().x;

			yCordinate = product.getLocation().y;

			scrollBy(xCordinate, yCordinate);

			System.out.println(product.getText());

			System.out.println("-----------------------------------");
		}
	}

	private void scrollBy(int X, int Y) {

		JavascriptExecutor jsEngine;

		jsEngine = (JavascriptExecutor) driver;

		String jsCommand = String.format("window.scrollBy(%d,%d)", X, Y);

		jsEngine.executeScript(jsCommand);

	}
}
