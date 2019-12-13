package pack;

public enum Classifier {
	
	IS_LONG_METHOD(8),
	IPLASMA(9),
	PMD(10),
	IS_FEATURE_ENVY(11),
	LONG_METHOD_DEFECT(12),
	FEATURE_ENVY_DEFECT(13);
	
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
