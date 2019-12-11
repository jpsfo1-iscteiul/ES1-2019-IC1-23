

public enum Classifier {
	
	IS_LONG_METHOD(8),
	IPLASMA(9),
	PMD(10),
	IS_FEATURE_ENVY(11);
	
	private final int column;
	private Classifier(int column) {
		this.column = column;
	}
	
	@Override
	public String toString() {
		return name().toUpperCase();
	}

	public int getColumn() {
		return column;
	}
}
