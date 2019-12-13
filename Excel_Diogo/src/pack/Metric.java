package pack;

public enum Metric {
	
	LOC(4),
	CYCLO(5),
	ATFD(6),
	LAA(7);
	
	private final int column;
	private Metric(int column) {
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
