package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Actions is a Class where as Action is a Interace.
 * Actions class doesn't have perform() method where as Action Interface is having the perform() method.
 * build() method is called if we have two or more series of actions to be compiled. build() method is used to composite your all the operations.
 * perform() method is having called by build().perform()
 * 
 * 
 */
public class ActionsClassDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins");

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com/");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);

		builder.moveToElement(txtUsername).click().keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello").keyUp(txtUsername, Keys.SHIFT).doubleClick(txtUsername).contextClick().perform();

//		builder.sendKeys(txtUsername,"Hello").doubleClick(txtUsername).contextClick(txtUsername).perform();
		

	}

}
