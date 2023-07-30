package ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practise {

	public static void main(String[] args) throws Throwable {
		System.out.println(new Practise().getData("Get_Data", 1, 1));
	}

	public String getData(String sheet, int row, int col) throws Throwable {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell data = book.getSheet(sheet).getRow(row).getCell(col);
		DataFormatter da = new DataFormatter();
		String dat = da.formatCellValue(data);
		return dat;
	}
}
