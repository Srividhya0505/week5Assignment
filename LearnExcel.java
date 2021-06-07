package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public String[][] exceData (String fileName) throws IOException {

		// setup workBook Path
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");

		// Setup WorkSheet Path
		XSSFSheet workSheet = wb.getSheet("Sheet1");

		// getlastrow
		int lastRow = workSheet.getLastRowNum();

		// lastCellNum
		int lastCell = workSheet.getRow(0).getLastCellNum();

		//declare 2D array
		String[][] data = new String[lastRow][lastCell];
		
		for (int i = 1; i <=lastRow; i++) {

			for (int j = 0; j < lastCell; j++) {

				String stringCellValue = workSheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print("\t" + stringCellValue);
				data [i-1][j] = stringCellValue;
				
			}

		}
		wb.close();
		
		return data;
			

	}
}
