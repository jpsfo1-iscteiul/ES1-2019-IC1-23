package pack;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Teste {
	
	public static void main(String[] Args) throws FileNotFoundException, IOException{
		MyFile myFile = new MyFile("Long-Method.xlsx");
		for(int i = 1; i<=myFile.getRowList().size(); i++){
			System.out.println(myFile.getRowOfMethodID(i).toString());
			System.out.println(myFile.getRowOfMethodID(i).getIPlasma());
		}
	}
	
}
