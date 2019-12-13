package pack;


import javax.swing.JTable;

public class Defects {

	private JTable table;

	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	private Classifier c;
	private String name;

	public Defects(JTable table, Classifier c){
		this.name = c.toString();
		this.table = table;
		this.c = c;
		readTable();
	}

	private void readTable(){
		for(int i = 0; i < table.getRowCount(); i++){
			boolean ferramenta = (Boolean)(table.getValueAt(i, c.getColumn()));
			if(c != Classifier.FEATURE_ENVY_DEFECT){
				boolean lm= (Boolean)(table.getValueAt(i, 8));
				if(lm == true && ferramenta == true)
					DCI++;
				if(lm == false && ferramenta == false)
					ADCI++;
				if(lm == false && ferramenta == true)
					DII++;
				if(lm == true && ferramenta == false)
					ADII++;
			} else{
				boolean fe = (Boolean)(table.getValueAt(i, 11));
				if(fe == true && ferramenta == true)
					DCI++;
				if(fe == false && ferramenta == false)
					ADCI++;
				if(fe == false && ferramenta == true)
					DII++;
				if(fe == true && ferramenta == false)
					ADII++;
			}
		}
	}

	public Integer getDCI(){
		return DCI;
	}

	public Integer getDII() {
		return DII;
	}

	public Integer getADCI() {
		return ADCI;
	}

	public Integer getADII() {
		return ADII;
	}
	
	public String getName() {
		return name;
	}

}

