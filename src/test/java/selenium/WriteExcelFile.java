package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class WriteExcelFile{
	
	@Test
	public static void writeToExcel() throws IOException {
		File file = new File("D:\\Study Materials\\MachineLearning\\demo.xlsx");
        FileInputStream fis = new FileInputStream(file);

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        String[] valueToWrite = {"Sangeetha","28"};
        
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount+1);
        for(int j=0;j<row.getLastCellNum();j++) {
        	Cell cell = newRow.createCell(j);
        	cell.setCellValue(valueToWrite[j]);
        	
        }
        System.out.println("Content has been written in to the excel....Pls check the Excel file");
        fis.close();
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();		
		
	}

}
