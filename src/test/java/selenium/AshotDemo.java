package selenium;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotDemo {
	
	@Test(priority=0)
	public static void ashotElementDemo() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://demo.guru99.com/test/guru99home/");
	    driver.manage().window().maximize();
	 // Find the element to take a screenshot

	    WebElement element = driver.findElement(By.xpath ("//*[@id='site-name']"));

	    // Along with driver pass element also in takeScreenshot() method.

	    Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5000)).takeScreenshot(driver,element);

	    ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\ElementScreenshot.jpg"));
	    driver.close();
	    	}
	
	@Test(priority=1)
	public static void ashotPageDemo() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://demo.guru99.com/test/guru99home/");
	    driver.manage().window().maximize();

	    // Along with driver pass element also in takeScreenshot() method.

//	    Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5000)).takeScreenshot(driver);

	    AShot shot = new AShot();
	    Screenshot screenshot=  shot.shootingStrategy(ShootingStrategies.viewportPasting(5000)).takeScreenshot(driver);
	    
	    ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\PageScreenshot.jpg"));
	    driver.close();
	    	}

	public static void main(String[] args) throws IOException {
		AshotDemo.ashotElementDemo();
		AshotDemo.ashotPageDemo();

	}

}
