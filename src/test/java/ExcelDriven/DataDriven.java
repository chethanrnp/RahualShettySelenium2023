package ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DataDriven {

	public static void main(String[] args) throws Throwable {
		// creating object of the class
		DataDriven dataDriven = new DataDriven();
		// get data of login
		ArrayList<String> loginData = dataDriven.getData("Login");
		System.out.println(loginData.get(1));
	}

	public String getDataFromExcelSheet(String path, String sheet, int r, int c) {
		String d = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook book = WorkbookFactory.create(fis);
			Cell data = book.getSheet(sheet).getRow(r).getCell(c);
			DataFormatter dat = new DataFormatter();
			d = dat.formatCellValue(data);
		} catch (Exception e) {

		}
		return d;
	}

	public ArrayList<String> getData(String testCaseName) throws Throwable {
		// creating the object of array list
		ArrayList<String> a = new ArrayList<String>();
		// helps to read the file
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Book1.xlsx");
		// Access the excel file
		Workbook book = WorkbookFactory.create(fis);
		// gets the number of sheet
		int sheets = book.getNumberOfSheets();
		// gets the sheet name
		for (int i = 0; i < sheets; i++) {
			if (book.getSheetName(i).equalsIgnoreCase("Get_Data")) {
				// storing complete data of sheet in a variable
				Sheet sheet = book.getSheetAt(i);
				// identify testCase coloumn by scanning the entire 1st row
				// control to all the row in the sheet
				Iterator<Row> row = sheet.iterator();
				// control to the first row
				Row firstRow = row.next();
				// to fetch all the data in the first row
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell cell = ce.next();
					if (cell.getStringCellValue().equalsIgnoreCase("Test cases")) {
						coloumn = k;
						break;
					}
					k++;
				}
				System.out.println(coloumn);
				// once the coloumn is identified then sacn the entire coloumn to identify
				// purchase in testcase row
				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// after you grab purchase in testCase row pull all the data in that row and
						// feed to test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								//converting integer to string in apache poi
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}

		}
		return a;

	}
}
