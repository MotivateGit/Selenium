package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFilesUsingWget {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64_117\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://demo.guru99.com/test/yahoo.html";

		driver.get(baseUrl);
		WebElement downloadButton = driver.findElement(By.id("messenger-download"));
		String sourceLocation = downloadButton.getAttribute("href");
		String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

		Process exec;
		try {
			exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (IOException | InterruptedException e) {
			System.out.println(e.toString());
		}

		driver.close();
	}

}
