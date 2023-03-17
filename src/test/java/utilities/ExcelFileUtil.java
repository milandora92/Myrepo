package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {

	XSSFWorkbook wb;

	public ExcelFileUtil(String filepath) throws Throwable
	{
		FileInputStream fi = new FileInputStream(filepath);
		wb = new XSSFWorkbook(fi);
	}
	public int nrow(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();

	}
	public String getcellData (String sheetname, int row,int cel )
	{
		String data = "";
		if (wb.getSheet(sheetname).getRow(row).getCell(cel).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(cel).getNumericCellValue();
			data = String.valueOf(celldata);
		}
		else {
			data = wb.getSheet(sheetname).getRow(row).getCell(cel).getStringCellValue(); 
		}
		return data;
	}
	public void setcellData (String sheetname, int row,int cel,String status,String Resultfilepath) throws Throwable
	{
		XSSFSheet ws = wb.getSheet(sheetname);
		XSSFRow Elrow = ws.getRow(row);
		XSSFCell Elcel = Elrow.createCell(cel);
		Elcel.setCellValue(status);
		FileOutputStream fo = new FileOutputStream(Resultfilepath);
		wb.write(fo);		
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		ExcelFileUtil xl = new ExcelFileUtil("C:\\Users\\hp\\Documents\\Sample.xlsx");
		int rc = xl.nrow("Sheet1");
		System.out.println(rc);
		for (int i = 1; i < rc; i++) {
			
		
		String fname = xl.getcellData("Sheet1", i, 0);
		String Email = xl.getcellData("Sheet1", i, 1);
		String Contact = xl.getcellData("Sheet1", i, 2);
		String Pword = xl.getcellData("Sheet1", i, 3);
		String Gender = xl.getcellData("Sheet1", i, 4);
		String DOB = xl.getcellData("Sheet1", i, 5);
		System.out.println(fname+ "   "+ Email+ "   "+ Contact+ "  "+ Pword+ "  "+ Gender+ "  "+DOB);
		xl.setcellData("Sheet1", i, 6, "Pass", "C:\\Users\\hp\\Documents\\Results.xlsx");
		
		
				
		}
	}

}
