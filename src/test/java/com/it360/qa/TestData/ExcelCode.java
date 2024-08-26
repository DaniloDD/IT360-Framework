package com.it360.qa.TestData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelCode {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellType cellType;
	public static FileInputStream ip;

	public static Object[][] readFromExcelSheet(String sheetname) throws IOException {
		ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/com/it360/qa/TestData/ExcelData_IT360.xlsx");
		workbook = new XSSFWorkbook(ip);
		sheet = workbook.getSheet(sheetname);
		int rowNums = sheet.getLastRowNum();
		int colNums = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowNums][colNums];
		for (int i = 0; i < rowNums; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colNums; j++) {
				cell = row.getCell(j);
				cellType = cell.getCellType();
				switch (cellType) {
				case NUMERIC: {
					data[i][j] = cell.getNumericCellValue();
					break;
				}
				case STRING: {
					data[i][j] = cell.getStringCellValue();
					break;
				}
				case BOOLEAN: {
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
				default:
					System.out.println("Celltype not valid");
				}
			}
		}
		return data;
	}
	
	@DataProvider(name = "LoginIT360")
	public Object[][] getLoginIT360ExcelData() throws IOException {
		Object[][] data = readFromExcelSheet("LoginIT360");
		return data;
	}
	
	@DataProvider(name = "RegisterIT360") 
	public Object[][] getRegisterIT360ExcelData() throws IOException {
		Object[][] data = readFromExcelSheet("RegisterIT360");
		return data;
	}
}