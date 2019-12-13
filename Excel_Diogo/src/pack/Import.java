//package pack;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Import {
//
////	
////	public static Rule newRule() {
////		List<Premisse> premisses = new ArrayList<Premisse>();
////		Scanner sc = new Scanner(System.in);
////		boolean stop = false;
////		while(stop == false) {
////			System.out.println("Enter Metric: (LOC,CYCLO,ATFD,LAA)");
////			Metric metric = Metric.valueOf(sc.next().toUpperCase());
////			System.out.println("Enter Comparison Operator: (BETWEEN,EQUAL,GE,GT,LE,LT,NOT_BETWEEN,NOT_EQUAL) ");
////			ComparisonOperator operator = ComparisonOperator.valueOf(sc.next().toUpperCase());
////			double min = 0;
////			double max = 0;
////			double value = 0;
////			if(operator.equals(ComparisonOperator.BETWEEN) || operator.equals(ComparisonOperator.NOT_BETWEEN)) {
////				System.out.println("Enter minimum value");
////				min = sc.nextDouble();
////				System.out.println("Enter maximum value");
////				max = sc.nextDouble();
////			} else {
////				System.out.println("Enter value");
////				value= sc.nextDouble();
////			}
////			Premisse premisse;
////			if(operator.equals(ComparisonOperator.BETWEEN) || operator.equals(ComparisonOperator.NOT_BETWEEN)) 
////				premisse = new Premisse(metric, operator, min, max);
////			else
////				premisse = new Premisse(metric,operator,value);
////			premisses.add(premisse);
////			System.out.println("Do you want to enter another premisse? YES/NO");
////			if(sc.next().toUpperCase().equals("NO"))
////				stop = true;
////		}
////		System.out.println("Conclusion:");
////		System.out.println("Enter Classifier: (IS_LONG_METHOD,IPLASMA,PMD,IS_FEATURE_ENVY)");
////		Classifier classifier = Classifier.valueOf(sc.next().toUpperCase());
////		System.out.println("Enter Result: TRUE/FALSE");
////		Boolean result = sc.hasNextBoolean();
////		Conclusion conclusion = new Conclusion(classifier,result);
////		sc.close();
////		return new Rule(premisses,conclusion);
////	}
//
//	public static void main(String[] args) {
//
//		try
//		{
//			FileInputStream file = new FileInputStream(new File("Long-Method.xlsx"));
//
//			//Create Workbook instance holding reference to .xlsx file
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//			//Get first/desired sheet from the workbook
//			XSSFSheet sheet = workbook.getSheetAt(0);
//
//			//Iterate through each rows one by one
//			Iterator<Row> rowIterator = sheet.iterator();
//			Rule rule = newRule();
//			System.out.println(rule);
//			while (rowIterator.hasNext()) 
//			{
//				Row row = rowIterator.next(); 
//				//For each row, iterate through all the columns
//				Iterator<Cell> cellIterator = row.cellIterator();
//				while (cellIterator.hasNext()) 
//				{
//					Cell cell = cellIterator.next();
//					//Check the cell type and format accordingly
//					switch (cell.getCellType()) 
//					{
//					case NUMERIC:
//						int value = (int) cell.getNumericCellValue();
//						if(value==cell.getNumericCellValue()) {
//							System.out.print(value + "\t");
//						} else {
//							System.out.print(cell.getNumericCellValue() + "\t");
//						}
//						break;
//					case STRING:
//						System.out.print(cell.getStringCellValue() + "\t");
//						break;
//					case BOOLEAN:
//						
////						if(cell.getColumnIndex() == rule.getConclusion().getClassifier().getColumn()) {
////							Boolean answer = false;
////							for (Premisse premisse : rule.getPremisses()) {
////								if(!premisse.isTrue(row.getCell(premisse.getMetric().getColumn()).getNumericCellValue())) {
////									answer = rule.getConclusion().getResult();
////									break;
////								}
////							}
//							System.out.print(answer.toString().toUpperCase() +"\t");
//							break;
//						} else {
//							System.out.print(cell.getBooleanCellValue() + "\t");
//						}
//						break;
//					default:
//						break;
//					}
//				}
//				System.out.println("");
//			}
//			file.close();
//			workbook.close();
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}
//}
