package javascript_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*getElementById
getElementByXpath
getElementByName
getElementByClassName*/

public class TypeTextInTextBox {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64_117\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.cssSelector("textarea#APjFqb"));

		// Send text to text box
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('APjFqb').value='Bharathiraja';");
		// Click
		WebElement loginButton = null;
		js.executeScript("document.getElementByXpath('xpath').click();");
		js.executeScript("arguments[0].click();", loginButton);
		//Handle Check box
		js.executeScript("document.getElementById('id').checked=false;");
		//To generate Alert Pop window in Selenium
		js.executeScript("alert('Welcome To SoftwareTestingMaterial');");
		//To refresh browser window using Javascript
		js.executeScript("history.go(0)");
		//To get innertext of the entire webpage in Selenium
		String sText =  js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(sText);
		
		//To get the Title of our webpage
		String sText1 =  js.executeScript("return document.title;").toString();
		System.out.println(sText1);
		
		//To get the URL of a webpage
		String sText2 =  js.executeScript("return document.URL;").toString();
		System.out.println(sText2);
		
		//To perform Scroll on an application using  Selenium
		
		//Vertical scroll - down by 500  pixels
		js.executeScript("window.scrollBy(0,500)");
		// for scrolling till the bottom of the page we can use the code like
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

}
