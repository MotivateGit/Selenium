package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserInCognitoMode {

	public static void main(String args[]) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.google.com");
		driver.manage().window().fullscreen();

	}
}
