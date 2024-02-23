package selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsInSelenium {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebElement ele = driver.findElement(By.xpath(null));
		//Implicit Wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit Wait
		
		WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		exWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		//Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
	
	
	}

}
