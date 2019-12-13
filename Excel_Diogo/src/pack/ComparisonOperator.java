package pack;

public enum ComparisonOperator {
	
	BETWEEN("IS BETWEEN"),
	EQUAL("="),
	GE(">="),
	GT(">"),
	LE("<="),
	LT("<"),
	NOT_BETWEEN("IS NOT BETWEEN"),
	NOT_EQUAL("!=");
	
	private final String s;
	private ComparisonOperator(String s) {
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s;
	}

}
