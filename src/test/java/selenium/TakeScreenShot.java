package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));

		File srcfile = element.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C://Bharathiraja/takescreenshot_element.png");
		FileUtils.copyFile(srcfile, destfile);

		driver.quit();

	}

}
