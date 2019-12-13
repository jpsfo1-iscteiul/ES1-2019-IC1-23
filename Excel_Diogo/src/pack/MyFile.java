package pack;
import java.util.ArrayList;
import java.util.List;

public class MyFile {

	private String fileName;
	private List<Row> rowList = new ArrayList<Row>();
	
	public MyFile(String fileName){
		this.fileName = fileName;
		readFile();
	}
	
	public Row getRowOfMethodID(int methodID){
		return rowList.get(methodID-1);
	}
	
	private void readFile(){
		ReadFile file = new ReadFile(fileName);
		rowList = file.readAllRows();
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public List<Row> getRowList(){
		return rowList;
	}
	
}
