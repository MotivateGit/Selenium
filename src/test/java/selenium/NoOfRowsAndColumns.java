package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NoOfRowsAndColumns {
	@Test
	public static void noOfRowsAndColumns() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		// No.of Rows
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr"));
		System.out.println("No of cols are : " + rows.size());
		// No.of Columns
		List<WebElement> cols = driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[1]/td"));
		System.out.println("No of rows are : " + cols.size());
		// Fetch the 3rd and 3rd column of Cell value
		WebElement CellValueEle = driver.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[3]"));
		String str = CellValueEle.getText();
		System.out.println(str);
		driver.close();

	}

}
