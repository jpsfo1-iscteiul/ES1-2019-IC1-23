package pack;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Tabela {

	private JFrame frame;
	private MyFile myFile;
	private JTable table_1;

	public JFrame getFrame() {
		return this.frame;
	}
	/**
	 * Launch the application.
	 */

	public Tabela(MyFile myFile) {
		this.myFile = myFile;
		initialize();
	}

	public Object[][] getValues(){
		int height = myFile.getRowList().size();
		Object[][] matrix = new Object[height][12];
		for (int i = 0; i < myFile.getRowList().size(); i++){
			Row row = myFile.getRowList().get(i);
			matrix[i][0] = row.getMethodID();
			matrix[i][1] = row.getPackageName();
			matrix[i][2] = row.getClassName();
			matrix[i][3] = row.getMethod();
			matrix[i][4] = row.getLoc();
			matrix[i][5] = row.getCyclo();
			matrix[i][6] = row.getAtdf();
			matrix[i][7] = row.getLaa();
			matrix[i][8] = row.getIsLongMethod();
			matrix[i][9] = row.getIPlasma();
			matrix[i][10] = row.getPmd();
			matrix[i][11] = row.getIsFeatureEnvy();
		}
		return matrix;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabela window = new Tabela(new MyFile("long-method.xlsx"));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1294, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1252, 647);
		frame.getContentPane().add(scrollPane);

		DefaultTableModel dtm = new DefaultTableModel(getValues(), new String[] {
				"MethodID", "New column","class", "method", "LOC", "CYCLO", "ATFD", "LAA", "is_long_method", "iPlasma", "PMD", "is_feature_envy"
		});
		//	table.setModel(new DefaultTableModel(getValues(),
		//		new String[] {
		//				"MethodID", "New column","class", "method", "LOC", "CYCLO", "ATFD", "LAA", "is_long_method", "iPlasma", "PMD", "is_feature_envy"
		//		}
		//	));
		table_1 = new JTable(dtm);
		JTableHeader header = table_1.getTableHeader();
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);
		header.setBackground(Color.MAGENTA);
		table_1.setBounds(136, 28, 738, 303);
		table_1.setEnabled(false);
		scrollPane.setViewportView(table_1);


	}

}
