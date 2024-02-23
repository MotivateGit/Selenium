package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * 
 * getOptions --> Used to get all the drop down options. getAllSeletedOptions
 * --> Used to get all the selected drop down options. getFirstSelectedOption
 * --> used to get the First selected drop down option.
 * 
 * 
 */
public class DropDownDemo {

	static WebDriver driver;

	public static void selectAlwaysLastOption() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://formstone.it/components/dropdown/demo/");
		Thread.sleep(5000);
		WebElement coverDD = driver.findElement(By.cssSelector("select[id*='demo_cover']"));

		Select select = new Select(coverDD);
		List<WebElement> dropDownElements = select.getOptions();
		int indx = dropDownElements.size() - 1;

		select.selectByIndex(indx);

	}

	public static void main(String[] args) throws InterruptedException {

		
		  System.setProperty("webdriver.chrome.driver",
		  "D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe"
		  );
		  
		  driver = new ChromeDriver();
		  driver.get("https://formstone.it/components/dropdown/demo/");
		  Thread.sleep(5000);
		  
		  WebElement dropDown =
		  driver.findElement(By.xpath("//select[@name='demo_basic']"));
		  
		  Select select = new Select(dropDown); List<WebElement> dropDownElements =
		  select.getOptions(); int size = dropDownElements.size();
		  System.out.println("NO of Drop down values: " + size);
		  
		  for (WebElement webElement : dropDownElements) {
		  System.out.println(webElement.getText()); }
		 
		
		selectAlwaysLastOption();

	}

}
