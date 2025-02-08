package com.sugarCRMGenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib extends WebDriverCommonLib {

	private static File f = null;
	private static FileOutputStream fos = null;
	private static FileInputStream fis = null;
	private static Workbook wb = null;
	private static Sheet sh = null;
	private static Row row = null;
	private static int rowcount;

	public ExcelLib(String fileLocation) {
		try {
			fis = new FileInputStream(fileLocation);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createExcel(String fileLocation, String sheetName) throws IOException {
		f = new File(fileLocation);
		if (f.exists()) {
			logger.info("File already exists");
		} else {
			f.createNewFile();
			logger.info("File created succesfully");
		}
		fos = new FileOutputStream(f);
		wb.createSheet(sheetName);
		wb.write(fos);
		fos.close();

	}

	public static void deleteExcel(String fileLocation, String fileName) {
		f = new File(fileLocation + "\\" + fileName);
		if (f.exists()) {
			f.delete();
			logger.info("File deleted succesfully");
		} else {
			logger.info("File not found for deletion..\n" + "Please mention the file name along with extesion..");
		}
	}

	public String Excelread(String sheetName, int cellnum) {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		String cellval = cell.getStringCellValue().toString();
		return cellval;

	}

	public String[][] ExcelreadFulldata(String sheetName) {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getPhysicalNumberOfRows();
		Row row = sh.createRow(rowcount);
		row = sh.getRow(rowcount - 1);
		int cellnum = row.getPhysicalNumberOfCells();
		String getDetails[][] = new String[rowcount][cellnum];
		for (int i = 1; i < rowcount; i++) {
			row = sh.getRow(i);
			for (int j = 0; j < cellnum; j++) {
				Cell cell = row.getCell(j);
				getDetails[i - 1][j] = cell.getStringCellValue();
			}
		}
		return getDetails;

	}

	public String Excelread(String sheetName, int rownum, int cellnum) {
		sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String cellval = cell.getStringCellValue();
		return cellval;

	}

	public double ExcelreadNumber(String sheetName, int rownum, int cellnum) throws Exception {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		return cell.getNumericCellValue();
	}

	public Boolean ExcelreadBoolean(String sheetName, int rownum, int cellnum) throws Exception {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		return cell.getBooleanCellValue();
	}

	public Date ExcelreadDate(String sheetName, int rownum, int cellnum) throws Exception {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		return cell.getDateCellValue();
	}

	public void Excelwrite(String filelocation, String sheetName, String data) {
		try {
			sh = wb.getSheet(sheetName);
			int colnum = sh.getRow(rowcount).getLastCellNum() + 1;
			Cell cell = row.createCell(colnum);
			cell.setCellValue(data);
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
			logger.info("Written Details on FileLocation: " + filelocation + " on Sheet: " + sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getCause().getCause();
		}

	}

	public void Excelwrite(String filelocation, String sheetName, String[] data) {
		try {
			sh = wb.getSheet(sheetName);
			rowcount = sh.getPhysicalNumberOfRows();
			@SuppressWarnings("unused")
			Row newrow = sh.createRow(rowcount);
			row = sh.getRow(rowcount);
			int colnum = sh.getRow(rowcount).getLastCellNum() + 1;
			for (int i = colnum; i < data.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(data[i]);
			}
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
			logger.info("Written Details on FileLocation: " + filelocation + " on Sheet: " + sheetName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Excelwrite(String filelocation, String sheetName, String[][] data) {
		try {
			sh = wb.getSheet(sheetName);
			for (int i = 0; i < data.length; i++) {
				rowcount = sh.getPhysicalNumberOfRows();
				@SuppressWarnings("unused")
				Row newrow = sh.createRow(rowcount);
				row = sh.getRow(rowcount);
				int colnum = sh.getRow(rowcount).getLastCellNum() + 1;
				for (int j = colnum; j < data[i].length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(data[i][j]);
				}
			}
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
			logger.info("Written Details on FileLocation: " + filelocation + " on Sheet: " + sheetName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public void ExcelDeleteData(String filelocation, String sheetName){ try {
	 * Sheet sheet = wb.getSheet(sheetName); rowcount =
	 * sheet.getPhysicalNumberOfRows(); Iterator<Row> rowIte = sheet.iterator();
	 * while(rowIte.hasNext()){ rowIte.next(); rowIte.remove(); } fos = new
	 * FileOutputStream(filelocation); wb.write(fos); fos.close();
	 * 
	 * logger.info("Deleted Details From FileLocation: "+ filelocation
	 * +" from Sheet: " + sheetName ); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	public void ExcelDeleteData(String filelocation, String sheetName) {
		try {
			int count = wb.getNumberOfSheets() - 1;
			wb.removeSheetAt(count);
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();

			logger.info("Deleted Details From FileLocation: " + filelocation + " from Sheet: " + sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getlastrownum(String sheetName) {
		sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}

	public int getlastcolnum(String sheetName, int rownum) {
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		return row.getLastCellNum();
	}

}
