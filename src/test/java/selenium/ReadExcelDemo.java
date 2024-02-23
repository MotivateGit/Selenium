package selenium;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDemo {
	@Test
	public static void readExcel() {
		try {
			File file = new File("D:\\Study Materials\\MachineLearning\\demo.xlsx");
			FileInputStream fis = new FileInputStream(file);

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + '\t');
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + '\t');
						break;
					}
				}
				System.out.println("");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
