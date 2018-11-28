package utitlities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.hssf.usermodel.examples.CellTypes;


public class ReadExcelFile {
	
	
	public static XSSFSheet ExcelWSheet;

	public static XSSFWorkbook ExcelWBook;

	public static XSSFCell Cell;

	//private static XSSFRow Row;
	
	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{
				 DataFormatter formatter = new DataFormatter(); 
  			Cell = ExcelWSheet.getRow(RowNum-1).getCell(ColNum-1);

  		String CellData = formatter.formatCellValue(Cell); 
  				
  				//Cell.getStringCellValue();
			
  			return CellData;
  			
			}
  		/*if (Cell == null)
				return "";
		 System.out.println(Cell.getCellType());
			if (Cell.getCellType() == Cell..CELL_TYPE_STRING)
				return Cell.getStringCellValue();
			else if (Cell.getCellType() == Cell.CELL_Type
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(Cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(Cell)) {
					// format in form of M/D/YY
					double d = Cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR)))
							.substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/"
							+ cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (Cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(Cell.getBooleanCellValue());


  			

  			}*/
  			
  			catch (Exception e){

				return"No";

  			}
			    }
    

}
