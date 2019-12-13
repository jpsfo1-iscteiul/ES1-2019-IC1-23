package pack;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Row> list = new ArrayList<Row>();
	
	public ReadFile(String fileName){
		try {
			workbook = new XSSFWorkbook(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
		sheet = workbook.getSheetAt(0);
	}
	
	public Row readRow(int numberOfRowToRead){
		XSSFRow row = sheet.getRow(numberOfRowToRead); 
		int methodID = (int)row.getCell(0).getNumericCellValue();
		String packageName = row.getCell(1).getStringCellValue();
		String className = row.getCell(2).getStringCellValue();
		String method = row.getCell(3).getStringCellValue();
		int loc = (int)row.getCell(4).getNumericCellValue();
		int cyclo = (int)row.getCell(5).getNumericCellValue();
		int atdf = (int)row.getCell(6).getNumericCellValue();
		String s = row.getCell(7).getCellType().toString();
		double laa;
		if(s.equals("NUMERIC"))
			laa = row.getCell(7).getNumericCellValue();
		else
			laa = Double.parseDouble(row.getCell(7).getStringCellValue());
		boolean isLongMethod, iPlasma, pmd, isFeatureEnvy;
		isLongMethod=row.getCell(8).getBooleanCellValue();
		iPlasma=row.getCell(9).getBooleanCellValue();
		pmd = row.getCell(10).getBooleanCellValue();
		isFeatureEnvy=row.getCell(11).getBooleanCellValue();
		
		return new Row(methodID, packageName, className, method, loc, cyclo, atdf, laa, isLongMethod, iPlasma, pmd, isFeatureEnvy);
	}
	
	public List<Row> readAllRows(){
		int last = sheet.getLastRowNum();
		for(int i = 1; i<=last; i++){
			Row row = readRow(i);
			list.add(row);
		}
		return list;
	}
	
}
