package pack;


import javax.swing.JTable;

// TODO: Auto-generated Javadoc
/**
 * The Class Defects.
 */
public class Defects {

	/** The table. */
	private JTable table;

	/** The dci. */
	private int DCI;
	
	/** The dii. */
	private int DII;
	
	/** The adci. */
	private int ADCI;
	
	/** The adii. */
	private int ADII;
	
	/** The c. */
	private Classifier c;
	
	/** The name. */
	private String name;

	/**
	 * Instantiates a new defects.
	 *
	 * @param table the table
	 * @param c the c
	 */
	public Defects(JTable table, Classifier c){
		this.name = c.toString();
		this.table = table;
		this.c = c;
		readTable();
	}

	/**
	 * Read table.
	 */
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

	/**
	 * Gets the dci.
	 *
	 * @return the dci
	 */
	public Integer getDCI(){
		return DCI;
	}

	/**
	 * Gets the dii.
	 *
	 * @return the dii
	 */
	public Integer getDII() {
		return DII;
	}

	/**
	 * Gets the adci.
	 *
	 * @return the adci
	 */
	public Integer getADCI() {
		return ADCI;
	}

	/**
	 * Gets the adii.
	 *
	 * @return the adii
	 */
	public Integer getADII() {
		return ADII;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}

