package pack;

// TODO: Auto-generated Javadoc
/**
 * The Enum ComparisonOperator.
 */
public enum ComparisonOperator {
	
	/** The between. */
	BETWEEN("IS BETWEEN"),
	
	/** The equal. */
	EQUAL("="),
	
	/** The ge. */
	GE(">="),
	
	/** The gt. */
	GT(">"),
	
	/** The le. */
	LE("<="),
	
	/** The lt. */
	LT("<"),
	
	/** The not between. */
	NOT_BETWEEN("IS NOT BETWEEN"),
	
	/** The not equal. */
	NOT_EQUAL("!=");
	
	/** The s. */
	private final String s;
	
	/**
	 * Instantiates a new comparison operator.
	 *
	 * @param s the s
	 */
	private ComparisonOperator(String s) {
		this.s = s;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return s;
	}

}
