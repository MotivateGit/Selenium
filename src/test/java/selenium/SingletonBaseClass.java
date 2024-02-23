package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*What is Singleton Design Pattern?
When we develop a class in such a way that it can have only instance at any time, is called Singleton design pattern. 
It is very useful when you need to use same object of a class across all classes or framework. Singleton class must return the same instance again, if it is instantiated again.*/

/*In this section, a Java singleton class will be used to create the driver class. This will force the user to use the same object for all instances
where the WebDriver is required. The WebDriver events will never get out of sync during the run, and all WebDriver events will get sent to the correct browser
or mobile device instance. And since the instance of the class is created on a single thread, referencing it won't interfere with other WebDriver instances 
running on the same node simultaneously.*/

public class SingletonBaseClass {

//	Declare a static reference variable of class. Static is needed to make it available globally.

	private static WebDriver driver = null;
	private static String browserName = "chrome";

	private SingletonBaseClass() {
		System.out.println("This is Singleton Design Pattern");
	}

	public static void init() {
		if (driver == null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

//	Declare a static method with return type as object of class which should check if class is already instantiated once.

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quit() {
		driver.quit();
		driver = null;
	}
}
