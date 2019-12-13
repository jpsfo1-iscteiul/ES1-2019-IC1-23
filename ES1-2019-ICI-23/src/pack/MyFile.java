package pack;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class MyFile.
 */
public class MyFile {

	/** The file name. */
	private String fileName;
	
	/** The row list. */
	private List<Row> rowList = new ArrayList<Row>();
	
	/**
	 * Instantiates a new my file.
	 *
	 * @param fileName the file name
	 */
	public MyFile(String fileName){
		this.fileName = fileName;
		readFile();
	}
	
	/**
	 * Gets the row of method ID.
	 *
	 * @param methodID the method ID
	 * @return the row of method ID
	 */
	public Row getRowOfMethodID(int methodID){
		return rowList.get(methodID-1);
	}
	
	/**
	 * Read file.
	 */
	private void readFile(){
		ReadFile file = new ReadFile(fileName);
		rowList = file.readAllRows();
	}
	
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName(){
		return fileName;
	}
	
	/**
	 * Gets the row list.
	 *
	 * @return the row list
	 */
	public List<Row> getRowList(){
		return rowList;
	}
	
}
