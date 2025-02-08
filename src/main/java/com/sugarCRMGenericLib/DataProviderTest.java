package com.sugarCRMGenericLib;

public class DataProviderTest {

	static ExcelApiTest eat = null;

	public static Object[][] testdata(String filename, String sheetname) {
		Object[][] exceldata = null;
		int rows = eat.getrowcount(sheetname);
		int columns = eat.getcolcount(sheetname);
		exceldata = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				exceldata[i - 1][j] = eat.getExceldata(sheetname, i, j);
			}

		}
		return exceldata;

	}

}
