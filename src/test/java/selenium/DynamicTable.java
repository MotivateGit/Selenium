package selenium;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void fetchNumberOfRowsAndColumns() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");
//	    WebDriver driver = new ChromeDriver();	

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/web-table-element.php");
		// No.of Columns
		List<WebElement> col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols are : " + col.size());
		// No.of rows
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("No of rows are : " + rows.size());
		driver.close();

	}

	public static void fetchCellValueOfParticularRowAndColumn() { // Fetch 3rd Row and 2nd Column's cell value
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement baseTable = driver.findElement(By.tagName("table"));

		// To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
		String rowtext = tableRow.getText();
		System.out.println("Third row of table : " + rowtext);

		// to get 3rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[3]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed);
		driver.close();
	}

	public static void fetchAllValuesInTheSpecificColumn() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement baseTable = driver.findElement(By.tagName("table"));
	}

	public static void fetchAllTheValuesFromTable() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Drivers\\chromedriver-win64-119\\chromedriver-win64-119\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement table = driver.findElement(By.xpath("//table[contains(@style,'margin-left')]/tbody"));
		List<WebElement> rowsTable = table.findElements(By.tagName("tr"));

		int rowsCount = rowsTable.size();
		for (int row = 0; row < rowsCount; row++) {

			List<WebElement> columnsRow = rowsTable.get(row).findElements(By.tagName("td"));
			int colCount = columnsRow.size();

			System.out.println("NO of Cells in the " + row + "th is: " + colCount);

			for (int column = 0; column < colCount; column++) {
				String colValue = columnsRow.get(column).getText();

				System.out.println("Cell value of row number " + row + " of column " + column + " is: " + colValue);
			}
			System.out.println("-------------------------------------------------- ");
		}

		driver.quit();

	}

	public static void main(String[] args) {
//		fetchNumberOfRowsAndColumns();
//		fetchCellValueOfParticularRowAndColumn();

		fetchAllTheValuesFromTable();

	}

}
