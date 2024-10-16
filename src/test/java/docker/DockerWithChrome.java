package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerWithChrome {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		
//		ChromeOptions co = new ChromeOptions();
//		co.setCapability(CapabilityType.BROWSER_NAME, "chrome");

		URL url = new URL("http://localhost:4444/wd/hub");

		WebDriver driver = new RemoteWebDriver(url, dc);

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

		System.out.println(driver.getTitle());

		driver.quit();

	}

}
