package com.sugarCRMGenericLib;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApiTest {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelApiTest(String filename) throws Exception {
		fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);

	}

	public String getExceldata(String sheetname, int rownum, int colnum) {
		try {
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellvalue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
					Date date = cell.getDateCellValue();
					cellvalue = dt.format(date);

				}
				return cellvalue;

			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No Matched Data";
		}

	}

	public int getrowcount(String sheetname) {
		sheet = workbook.getSheet(sheetname);
		return sheet.getLastRowNum();
	}

	public int getcolcount(String sheetname) {
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(getrowcount(sheetname));
		return row.getLastCellNum();
	}

	public static void main(String[] args) throws Exception {

		ExcelApiTest exl = new ExcelApiTest("./MasterData.xlsx");
		System.out.println(exl.getExceldata("Routetestdata", 1, 5));

	}

}
