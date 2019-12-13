package pack;

import java.util.List;

public class FailureDetection {
	//private static String FILE_PATH=GUI.get();
	List<Row> compareFile;
	private ReadFile rf=new ReadFile("Long-Method-xlsx");
	
	public FailureDetection() {
		this.compareFile=rf.readAllRows();
	}
	
	 
	/*- DCI, quando o valor da coluna correspondente à ferramenta (PMI ou iPlasma) é TRUE e a coluna
	is_long_method também é TRUE; */
	public int dc1() {
		int counter=0;
		for(Row r: compareFile) {
			if(r.getIPlasma() && r.getIsLongMethod()) {
				counter++;
			}
		}
		return counter;
	}
	/*- DII, quando o valor da coluna correspondente à ferramenta (PMI ou iPlasma) é TRUE e a coluna
	is_long_method é FALSE; */
	public int dc2() {
		int counter=0;
		for(Row r: compareFile) {
			if(r.getIPlasma() && !r.getIsLongMethod()) {
				counter++;
			}
		}
		return counter;
	}
	/* - ADCI, quando o valor da coluna correspondente à ferramenta (PMI ou iPlasma) é FALSE e a coluna
	is_long_method também é FALSE; */
	
	/*- ADII, quando o valor da coluna correspondente à ferramenta (PMI ou iPlasma) é FALSE e a coluna
	is_long_method é TRUE. */
}