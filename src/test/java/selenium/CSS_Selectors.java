package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selectors {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// tag#id value --> # denotes id
		// tag.class value --> . denotes class
		// tag[attrubute=value]
		// tag:contains("inner text")
		// tag.class[attribute=value]

		driver.findElement(By.cssSelector("input#email")).sendKeys("Bharathiraja");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("Bharathiraja");
		driver.findElement(By.cssSelector("button[name=login]")).click();
		Thread.sleep(5000);
		driver.quit();

		// Difference Between CSS Selector and Xpath?

		/*
		 * 1. we can move from parent to child element and also from child to the parent
		 * element with XPath. for css, we can only traverse from parent to child and
		 * not vice-versa. 2.In terms of performance, css is better and faster, while
		 * xpath is on a slower side.
		 */

	}

}
