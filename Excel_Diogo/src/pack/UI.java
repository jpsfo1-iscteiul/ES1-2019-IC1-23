package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

// TODO: Auto-generated Javadoc
/**
 * The Class UI.
 */
public class UI {

	/** The frame. */
	private JFrame frame;
	
	/** The lm text field. */
	private JTextField lm_textField;
	
	/** The lm text field 1. */
	private JTextField lm_textField_1;
	
	/** The lm text field 3. */
	private JTextField lm_textField_3;
	
	/** The lm text field 2. */
	private JTextField lm_textField_2;
	
	/** The fe text field. */
	private JTextField fe_textField;
	
	/** The fe text field 1. */
	private JTextField fe_textField_1;
	
	/** The fe text field 2. */
	private JTextField fe_textField_2;
	
	/** The fe text field 3. */
	private JTextField fe_textField_3;
	
	/** The table. */
	private JTable table;
	
	/** The defects. */
	private Defects defects;
	
	/** The ui. */
	private UI ui = this;
	
	/** The fe new rule. */
	private JButton feNewRule;
	
	/** The lm new rule. */
	private JButton lmNewRule;
	
	/**
	 * Gets the lm new rule.
	 *
	 * @return the lm new rule
	 */
	public JButton getLmNewRule() {
		return this.lmNewRule;
	}


	/**
	 * Gets the fe new rule.
	 *
	 * @return the fe new rule
	 */
	public JButton getFeNewRule() {
		return this.feNewRule;
	}
	/**
	 * Launch the application.
	 */
	private MyFile myFile;
	
	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
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
	public UI() {
		this.myFile = new MyFile("long-method.xlsx");
		initialize();
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	private Object[][] getValues(){
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


	/**
	 * Fill column.
	 *
	 * @param rule the rule
	 */
	public void fillColumn(Rule rule) {
		int columnNumber;
		if(rule.getConclusion().getClassifier().equals(Classifier.IS_LONG_METHOD)) 
			columnNumber = 12;
		else 
			columnNumber = 13;
		int height = myFile.getRowList().size();
		if(rule.getAndOr().equals("")) {
			int columnToCheck = rule.getPremisse1().getMetric().getColumn();
			for(int i = 0; i < height; i++) {
				double cellValue;
				if(columnToCheck == 7 )
					cellValue = (double) table.getValueAt(i, columnToCheck);
				else
					cellValue =  (double) ((int)table.getValueAt(i,columnToCheck));
				boolean result = rule.getResult(cellValue);
				table.setValueAt(result, i, columnNumber);
			}
		} else {
			int columnToCheck1 = rule.getPremisse1().getMetric().getColumn();
			int columnToCheck2 = rule.getPremisse2().getMetric().getColumn();
			for(int i = 0; i < height; i++) {
				double cellValue1;
				double cellValue2;
				if(columnToCheck1 == 7)
					cellValue1 = (double) table.getValueAt(i, columnToCheck1);
				else
					cellValue1 = (double) ((int)table.getValueAt(i,columnToCheck1));
				if(columnToCheck2 == 7)
					cellValue2 = (double) table.getValueAt(i, columnToCheck2);
				else
					cellValue2 = (double) ((int)table.getValueAt(i,columnToCheck2));
				boolean result = rule.getResult(cellValue1, cellValue2);
				table.setValueAt(result, i, columnNumber);
			}
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1283, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblIf = new JLabel("IF");
		lblIf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIf.setBounds(39, 22, 56, 16);
		frame.getContentPane().add(lblIf);


		lm_textField = new JTextField();
		lm_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD && !lm_textField.getText().contains("."))) {
					e.consume();
				}
			}
		});
		lm_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lm_textField.setBounds(288, 23, 94, 16);
		frame.getContentPane().add(lm_textField);
		lm_textField.setColumns(10);

		lm_textField_1 = new JTextField();

		lm_textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD && !lm_textField_1.getText().contains("."))) {
					e.consume();
				}
			}
		});
		lm_textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lm_textField_1.setBounds(431, 23, 94, 16);
		frame.getContentPane().add(lm_textField_1);
		lm_textField_1.setColumns(10);

		JComboBox lm_metricBox2 = new JComboBox(new Metric[] { Metric.LOC, Metric.CYCLO });
		lm_metricBox2.setBounds(77, 51, 74, 16);
		lm_metricBox2.setVisible(false);
		frame.getContentPane().add(lm_metricBox2);

		JComboBox lm_metricBox1 = new JComboBox(new Metric[] { Metric.LOC, Metric.CYCLO } );
		lm_metricBox1.setBounds(77, 22, 74, 16);
		frame.getContentPane().add(lm_metricBox1);

		JComboBox lm_operatorBox2 = new JComboBox(ComparisonOperator.values());
		lm_operatorBox2.setBounds(163, 51, 113, 16);
		lm_operatorBox2.setVisible(false);
		frame.getContentPane().add(lm_operatorBox2);


		lm_textField_3 = new JTextField();

		lm_textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD && !lm_textField_3.getText().contains("."))) {
					e.consume();
				}
			}
		});

		lm_textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lm_textField_3.setBounds(431, 50, 94, 16);
		lm_textField_3.setVisible(false);
		frame.getContentPane().add(lm_textField_3);
		lm_textField_3.setColumns(10);

		lm_textField_2 = new JTextField();
		lm_textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD && !lm_textField_2.getText().contains("."))) {
					e.consume();
				}
			}
		});

		lm_textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lm_textField_2.setVisible(false);
		lm_textField_2.setBounds(288, 50, 94, 16);
		frame.getContentPane().add(lm_textField_2);
		lm_textField_2.setColumns(10);


		JComboBox lm_operatorBox1 = new JComboBox(ComparisonOperator.values());
		lm_operatorBox1.setBounds(163, 22, 113, 16);
		frame.getContentPane().add(lm_operatorBox1);

		JComboBox lm_andOrBox = new JComboBox(new String[] {"","AND","OR"});
		lm_andOrBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lm_andOrBox.setBounds(537, 24, 56, 16);
		frame.getContentPane().add(lm_andOrBox);

		JLabel lblIs = new JLabel("IS");
		lblIs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIs.setBounds(800, 14, 34, 32);
		frame.getContentPane().add(lblIs);

		JComboBox lmResult = new JComboBox(new String[] { "TRUE"," FALSE"});
		lmResult.setBounds(824, 24, 74, 16);
		frame.getContentPane().add(lmResult);


		List<Rule> lmRules = new ArrayList<Rule>();
		JComboBox lm_rules = new JComboBox();
		lm_rules.setBounds(1044, 22, 125, 23);
		frame.getContentPane().add(lm_rules);
		
		JComboBox Combo_DC = new JComboBox(new Classifier[] { null, Classifier.IPLASMA, Classifier.PMD});
		Combo_DC.setBounds(39, 594, 113, 37);
		frame.getContentPane().add(Combo_DC);

		lm_rules.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					for (Rule rule : lmRules) {
						if(rule.getName().equals(lm_rules.getSelectedItem())) {
							fillColumn(rule);
							break;
						}
					}
					Combo_DC.setSelectedItem(Classifier.IPLASMA);
					Combo_DC.setSelectedItem(Classifier.LONG_METHOD_DEFECT);
				}

			}
		});

		JLabel lblThan = new JLabel("THAN");
		lblThan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThan.setBounds(605, 24, 56, 14);
		frame.getContentPane().add(lblThan);

		JLabel lblNewLabel = new JLabel("is_long_method");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(648, 14, 140, 32);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblAnd = new JLabel("AND");
		lblAnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnd.setBounds(394, 24, 56, 16);
		frame.getContentPane().add(lblAnd);

		JLabel lblAnd_1 = new JLabel("AND");
		lblAnd_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnd_1.setBounds(394, 51, 56, 16);
		lblAnd_1.setVisible(false);
		frame.getContentPane().add(lblAnd_1);
		

		lmNewRule = new JButton("New Rule");
		lmNewRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(lm_textField.getText().isEmpty())
					lm_textField.setText("0");
				if(lm_textField_1.getText().isEmpty())
					lm_textField_1.setText("0");
				if(lm_textField_2.getText().isEmpty())
					lm_textField_2.setText("0");
				if(lm_textField_3.getText().isEmpty())
					lm_textField_3.setText("0");

				Premisse premisse1;
				Metric metric = (Metric)lm_metricBox1.getSelectedItem();
				ComparisonOperator operator = (ComparisonOperator) lm_operatorBox1.getSelectedItem();
				Rule rule;
				if(lm_operatorBox1.getSelectedItem().equals(ComparisonOperator.BETWEEN) || lm_operatorBox1.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
					double min = Double.parseDouble(lm_textField.getText());
					double max = Double.parseDouble(lm_textField_1.getText());
					premisse1 = new Premisse(metric,operator,min,max);
				} else {
					double value = Double.parseDouble(lm_textField.getText());
					premisse1 = new Premisse(metric, operator, value);
				}
				Boolean result = Boolean.parseBoolean(lmResult.getSelectedItem().toString());
				Conclusion conclusion = new Conclusion(Classifier.IS_LONG_METHOD,result);
				String name = "lm_Rule" + (lmRules.size() + 1);
				if(lm_andOrBox.getSelectedItem().equals("")) {
					rule = new Rule(name,premisse1,conclusion);
				}
				//					Premisse premisse1 = new Premisse(lm_metricBox1.getSelectedItem();
				else {
					Premisse premisse2;
					Metric metric2 = (Metric)lm_metricBox2.getSelectedItem();
					ComparisonOperator operator2 = (ComparisonOperator) lm_operatorBox2.getSelectedItem();
					if(lm_operatorBox2.getSelectedItem().equals(ComparisonOperator.BETWEEN) || lm_operatorBox2.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
						double min = Double.parseDouble(lm_textField_2.getText());
						double max = Double.parseDouble(lm_textField_3.getText());
						premisse2 = new Premisse(metric2,operator2,min,max);
					} else {
						double value = Double.parseDouble(lm_textField_2.getText());
						premisse2 = new Premisse(metric2, operator2, value);
					}
					String andOr = lm_andOrBox.getSelectedItem().toString();
					rule = new Rule(name, premisse1,premisse2,andOr,conclusion);
				}
				if(lmRules.size() == 0)
					Combo_DC.addItem(Classifier.LONG_METHOD_DEFECT);
				lmRules.add(rule);
				lm_rules.addItem(name);
				lm_rules.setSelectedItem(name);
				

			}
		});
		lmNewRule.setBackground(Color.LIGHT_GRAY);
		lmNewRule.setForeground(Color.BLACK);
		lmNewRule.setBounds(926, 20, 97, 25);
		frame.getContentPane().add(lmNewRule);

		JLabel lblIf_1 = new JLabel("IF");
		lblIf_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIf_1.setBounds(39, 90, 56, 16);
		frame.getContentPane().add(lblIf_1);

		JComboBox fe_metricBox1 = new JComboBox(new Metric[] { Metric.ATFD, Metric.LAA });
		fe_metricBox1.setBounds(77, 90, 74, 16);
		frame.getContentPane().add(fe_metricBox1);

		JComboBox fe_operatorBox_1 = new JComboBox(ComparisonOperator.values());
		fe_operatorBox_1.setBounds(163, 90, 113, 16);

		frame.getContentPane().add(fe_operatorBox_1);

		fe_textField = new JTextField();
		fe_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fe_textField.setColumns(10);
		fe_textField.setBounds(288, 90, 94, 16);
		frame.getContentPane().add(fe_textField);

		JLabel fe_label = new JLabel("AND");
		fe_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fe_label.setBounds(394, 90, 56, 16);
		frame.getContentPane().add(fe_label);

		fe_textField_1 = new JTextField();
		fe_textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fe_textField_1.setColumns(10);
		fe_textField_1.setBounds(431, 89, 94, 16);
		frame.getContentPane().add(fe_textField_1);

		JComboBox fe_andOrBox = new JComboBox(new String[] { "", "AND", "OR"});
		fe_andOrBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		fe_andOrBox.setBounds(537, 89, 56, 16);
		frame.getContentPane().add(fe_andOrBox);

		JLabel label_1 = new JLabel("THAN");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(605, 88, 56, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("is_feature_envy");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(648, 78, 140, 32);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("IS");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(800, 78, 34, 32);
		frame.getContentPane().add(label_3);

		JComboBox feResult = new JComboBox(new String[] { "TRUE", "FALSE"});
		feResult.setBounds(824, 88, 74, 16);
		frame.getContentPane().add(feResult);


		feNewRule = new JButton("New Rule");

		feNewRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fe_textField.getText().isEmpty())
					fe_textField.setText("0");
				if(fe_textField_1.getText().isEmpty())
					fe_textField_1.setText("0");
				if(fe_textField_2.getText().isEmpty())
					fe_textField_2.setText("0");
				if(fe_textField_3.getText().isEmpty())
					fe_textField_3.setText("0");

			}
		});
		feNewRule.setForeground(Color.BLACK);
		feNewRule.setBackground(Color.LIGHT_GRAY);
		feNewRule.setBounds(926, 86, 97, 25);
		frame.getContentPane().add(feNewRule);



		JComboBox fe_metricBox_2 = new JComboBox(new Metric[] {Metric.ATFD, Metric.LAA });
		fe_metricBox_2.setBounds(77, 119, 74, 16);
		frame.getContentPane().add(fe_metricBox_2);

		JComboBox fe_operatorBox_2 = new JComboBox(ComparisonOperator.values());
		fe_operatorBox_2.setBounds(163, 119, 113, 16);
		frame.getContentPane().add(fe_operatorBox_2);

		fe_textField_2 = new JTextField();
		fe_textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fe_textField_2.setColumns(10);
		fe_textField_2.setBounds(288, 119, 94, 16);
		frame.getContentPane().add(fe_textField_2);

		JLabel fe_label_1 = new JLabel("AND");
		fe_label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fe_label_1.setBounds(394, 119, 56, 16);
		frame.getContentPane().add(fe_label_1);

		fe_textField_3 = new JTextField();
		fe_textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fe_textField_3.setColumns(10);
		fe_textField_3.setBounds(431, 119, 94, 16);
		frame.getContentPane().add(fe_textField_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 157, 1143, 402);
		frame.getContentPane().add(scrollPane);

		List<Rule> feRules = new ArrayList<Rule>();
		JComboBox fe_rules = new JComboBox();

		fe_rules.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					for (Rule rule : feRules) {
						if(rule.getName().equals(fe_rules.getSelectedItem())) {
							fillColumn(rule);
							break;
						}
					}
					fe_rules.setSelectedItem(Classifier.IPLASMA);
					fe_rules.setSelectedItem(Classifier.FEATURE_ENVY_DEFECT);
				}

			}
		});
		fe_rules.setBounds(1044, 89, 125, 23);
		frame.getContentPane().add(fe_rules);

		feNewRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fe_textField.getText().isEmpty())
					fe_textField.setText("0");
				if(fe_textField_1.getText().isEmpty())
					fe_textField_1.setText("0");
				if(fe_textField_3.getText().isEmpty())
					fe_textField_3.setText("0");
				if(fe_textField_2.getText().isEmpty())
					fe_textField_2.setText("0");

				Premisse premisse1;
				Metric metric = (Metric)fe_metricBox1.getSelectedItem();
				ComparisonOperator operator = (ComparisonOperator) fe_operatorBox_1.getSelectedItem();
				Rule rule;
				if(fe_operatorBox_1.getSelectedItem().equals(ComparisonOperator.BETWEEN) || fe_operatorBox_1.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
					double min = Double.parseDouble(fe_textField.getText());
					double max = Double.parseDouble(fe_textField_1.getText());
					premisse1 = new Premisse(metric,operator,min,max);
				} else {
					double value = Double.parseDouble(fe_textField.getText());
					premisse1 = new Premisse(metric, operator, value);
				}
				Boolean result = Boolean.parseBoolean(feResult.getSelectedItem().toString());
				Conclusion conclusion = new Conclusion(Classifier.IS_FEATURE_ENVY,result);
				String name = "fe_Rule" + (feRules.size() + 1);
				if(fe_andOrBox.getSelectedItem().equals("")) {
					rule = new Rule(name,premisse1,conclusion);
				}
				//					Premisse premisse1 = new Premisse(fe_metricBox1.getSelectedItem();
				else {
					Premisse premisse2;
					Metric metric2 = (Metric)fe_metricBox_2.getSelectedItem();
					ComparisonOperator operator2 = (ComparisonOperator) fe_operatorBox_2.getSelectedItem();
					if(fe_operatorBox_2.getSelectedItem().equals(ComparisonOperator.BETWEEN) || fe_operatorBox_2.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
						double min = Double.parseDouble(fe_textField_2.getText());
						double max = Double.parseDouble(fe_textField_3.getText());
						premisse2 = new Premisse(metric2,operator2,min,max); 
					} else {
						double value = Double.parseDouble(fe_textField_2.getText());
						premisse2 = new Premisse(metric2, operator2, value);
					}
					String andOr = fe_andOrBox.getSelectedItem().toString();
					rule = new Rule(name, premisse1,premisse2,andOr,conclusion);
				}

				if(feRules.size()==0)
					Combo_DC.addItem(Classifier.FEATURE_ENVY_DEFECT);
				
				feRules.add(rule);
				fe_rules.addItem(name);
				fe_rules.setSelectedItem(name);
				


			}
		});

		lm_andOrBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(lm_andOrBox.getSelectedItem().equals("")) {
					lm_operatorBox2.setVisible(false);
					lm_metricBox2.setVisible(false);
					lm_textField_2.setVisible(false);
					lm_textField_3.setVisible(false);
					lblAnd_1.setVisible(false);
				} else {
					lm_operatorBox2.setVisible(true);
					lm_metricBox2.setVisible(true);
					lm_textField_2.setVisible(true);
					lm_textField_3.setVisible(true);
					lblAnd_1.setVisible(true);
				}
			}
		});

		fe_metricBox_2.setVisible(false);
		fe_operatorBox_2.setVisible(false);
		fe_textField_2.setVisible(false);
		fe_label_1.setVisible(false);
		fe_textField_3.setVisible(false);

		lm_operatorBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!lm_operatorBox1.getSelectedItem().equals(ComparisonOperator.BETWEEN) && !lm_operatorBox1.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
					lm_textField_1.setVisible(false);
					lblAnd.setVisible(false);
				}
				else {
					lm_textField_1.setVisible(true);
					lblAnd.setVisible(true);
				}

			}
		});


		lm_operatorBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!lm_operatorBox2.getSelectedItem().equals(ComparisonOperator.BETWEEN) && !lm_operatorBox2.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
					lm_textField_3.setVisible(false);
					lblAnd_1.setVisible(false);
				} else {
					lm_textField_3.setVisible(true);
					lblAnd_1.setVisible(true);
				}
			}
		});

		fe_operatorBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!fe_operatorBox_1.getSelectedItem().equals(ComparisonOperator.BETWEEN) && !fe_operatorBox_1.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
					fe_textField_1.setVisible(false);
					fe_label.setVisible(false);
				} else {
					fe_textField_1.setVisible(true);
					fe_label.setVisible(true);
				}
			}
		});

		fe_operatorBox_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!fe_operatorBox_2.getSelectedItem().equals(ComparisonOperator.BETWEEN) && !fe_operatorBox_1.getSelectedItem().equals(ComparisonOperator.NOT_BETWEEN)) {
					fe_textField_3.setVisible(false);
					fe_label_1.setVisible(false);
				} else {
					fe_textField_3.setVisible(true);
					fe_label_1.setVisible(true);
				}
			}
		});

		fe_andOrBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fe_andOrBox.getSelectedItem().equals("")) {
					fe_metricBox_2.setVisible(false);
					fe_operatorBox_2.setVisible(false);
					fe_textField_2.setVisible(false);
					fe_label_1.setVisible(false);
					fe_textField_3.setVisible(false);
				} else {
					fe_metricBox_2.setVisible(true);
					fe_operatorBox_2.setVisible(true);
					fe_textField_2.setVisible(true);
					fe_label_1.setVisible(true);
					fe_textField_3.setVisible(true);
				}
			}
		});

		DefaultTableModel dtm = new DefaultTableModel(getValues(), new String[] {
				"MethodID","package","class", "method", "LOC", "CYCLO", "ATFD", "LAA", "is_long_method", "iPlasma", "PMD", "is_feature_envy","lm_rule","fe_rule"
		});


		//	table.setModel(new DefaultTableModel(getValues(),
		//		new String[] {
		//				"MethodID", "New column","class", "method", "LOC", "CYCLO", "ATFD", "LAA", "is_long_method", "iPlasma", "PMD", "is_feature_envy"
		//		}
		//	));
		table = new JTable(dtm);


		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		header.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);

		JLabel lblDci = new JLabel("DCI");
		lblDci.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDci.setBounds(188, 559, 97, 37);
		frame.getContentPane().add(lblDci);

		JTextPane textPane_DCI = new JTextPane();
		textPane_DCI.setEditable(false);
		textPane_DCI.setBounds(171, 594, 74, 37);
		frame.getContentPane().add(textPane_DCI);

		JLabel lblDii = new JLabel("DII");
		lblDii.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDii.setBounds(275, 569, 56, 16);
		frame.getContentPane().add(lblDii);

		JTextPane textPane_DII = new JTextPane();
		textPane_DII.setEditable(false);
		textPane_DII.setBounds(257, 594, 74, 37);
		frame.getContentPane().add(textPane_DII);

		JLabel lblAdci = new JLabel("ADCI");
		lblAdci.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdci.setBounds(355, 569, 56, 16);
		frame.getContentPane().add(lblAdci);

		JTextPane textPane_ADCI = new JTextPane();
		textPane_ADCI.setEditable(false);
		textPane_ADCI.setBounds(343, 594, 74, 37);
		frame.getContentPane().add(textPane_ADCI);

		JLabel lblAdii = new JLabel("ADII");
		lblAdii.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdii.setBounds(447, 569, 56, 16);
		frame.getContentPane().add(lblAdii);

		JTextPane textPane_ADII = new JTextPane();
		textPane_ADII.setEditable(false);
		textPane_ADII.setBounds(429, 594, 74, 37);
		frame.getContentPane().add(textPane_ADII);


		Combo_DC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					defects = new Defects(table, (Classifier) Combo_DC.getSelectedItem());
					textPane_DCI.setText(defects.getDCI().toString());
					textPane_DII.setText(defects.getDII().toString());
					textPane_ADCI.setText(defects.getADCI().toString());
					textPane_ADII.setText(defects.getADII().toString());

				}

			}
		});

	}
}
