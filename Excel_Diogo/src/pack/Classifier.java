package pack;

// TODO: Auto-generated Javadoc
/**
 * The Enum Classifier.
 */
public enum Classifier {
	
	/** The is long method. */
	IS_LONG_METHOD(8),
	
	/** The iplasma. */
	IPLASMA(9),
	
	/** The pmd. */
	PMD(10),
	
	/** The is feature envy. */
	IS_FEATURE_ENVY(11),
	
	/** The long method defect. */
	LONG_METHOD_DEFECT(12),
	
	/** The feature envy defect. */
	FEATURE_ENVY_DEFECT(13);
	
	/** The column. */
	private final int column;
	
	/**
	 * Instantiates a new classifier.
	 *
	 * @param column the column
	 */
	private Classifier(int column) {
		this.column = column;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return name().toUpperCase();
	}

	/**
	 * Gets the column.
	 *
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
}
