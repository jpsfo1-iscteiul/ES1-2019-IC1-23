package pack;

// TODO: Auto-generated Javadoc
/**
 * The Enum Metric.
 */
public enum Metric {
	
	/** The loc. */
	LOC(4),
	
	/** The cyclo. */
	CYCLO(5),
	
	/** The atfd. */
	ATFD(6),
	
	/** The laa. */
	LAA(7);
	
	/** The column. */
	private final int column;
	
	/**
	 * Instantiates a new metric.
	 *
	 * @param column the column
	 */
	private Metric(int column) {
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
