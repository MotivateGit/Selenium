package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiThreadingDemo extends Thread {
	private WebDriver driver;
	private String browserType;

	public MultiThreadingDemo(String name, String browserType) {
		super(name);
		this.browserType = browserType;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("This is the thread name: " + threadName);
		try {
			Thread.sleep(3000);
			setup(browserType);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void setup(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	public static void main(String[] args) {
		Thread t1 = new MultiThreadingDemo("ChromeDriver Thread", "chrome");
		Thread t2 = new MultiThreadingDemo("FirefoxDriver Thread", "firefox");
		t1.start();
		t2.start();

	}

}
