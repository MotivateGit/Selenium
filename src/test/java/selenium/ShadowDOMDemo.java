package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ShadowDOMDemo {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");

		Thread.sleep(10000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement fileElement = (WebElement) jse.executeScript(
				"return document.querySelector(\"smart-ui-menu\").shadowRoot.querySelector(\"smart-menu > div > div.smart-menu-main-container > smart-menu-items-group > div > div > span\")");

		
		JavascriptExecutor click = (JavascriptExecutor) driver;
		click.executeScript("arguments[0].click();", fileElement);

	}

}
