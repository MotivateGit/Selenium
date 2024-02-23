package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowsHandling {

	@Test
	public static void windowsHandling() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[text()='Click Here']")).click();
		Thread.sleep(5000);

		Set<String> childWindows = driver.getWindowHandles();
		Iterator<String> it = childWindows.iterator();
		while (it.hasNext()) {
			String child = it.next();
			if (!mainWindow.equals(child)) {
				driver.switchTo().window(child);
				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");

				driver.findElement(By.name("btnLogin")).click();

				// Closing the Child Window.
				driver.close();
			}

		}

		driver.switchTo().window(mainWindow);

		// driver.switchTo().defaultContent();

	}

}
