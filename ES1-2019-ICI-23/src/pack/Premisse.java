package pack;


// TODO: Auto-generated Javadoc
/**
 * The Class Premisse.
 */
public class Premisse {
	
	/** The metric. */
	private Metric metric;
	
	/** The operator. */
	private ComparisonOperator operator;
	
	/** The value. */
	private double value;
	
	/** The min. */
	private double min;
	
	/** The max. */
	private double max;
	
	/**
	 * Instantiates a new premisse.
	 *
	 * @param metric the metric
	 * @param operator the operator
	 * @param value the value
	 */
	public Premisse(Metric metric, ComparisonOperator operator, double value) {
		this.metric = metric;
		this.operator = operator;
		this.value = value;
	}
	
	/**
	 * Instantiates a new premisse.
	 *
	 * @param metric the metric
	 * @param operator the operator
	 * @param min the min
	 * @param max the max
	 */
	public Premisse(Metric metric, ComparisonOperator operator, double min, double max) {
		this.metric = metric;
		this.operator = operator;
		this.min = min;
		this.max = max;
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		if(operator.equals(ComparisonOperator.BETWEEN) || operator.equals(ComparisonOperator.NOT_BETWEEN))
			return(metric + " " + operator + " " + min + " AND " + max + " ");
		return(metric + " " + operator + " " + value + " ");
		
	}
	
	/**
	 * Gets the metric.
	 *
	 * @return the metric
	 */
	public Metric getMetric() {
		return metric;
	}
	
	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public ComparisonOperator getOperator() {
		return operator;
	}
	
	/**
	 * Checks if is true.
	 *
	 * @param cellValue the cell value
	 * @return true, if is true
	 */
	public boolean isTrue(double cellValue) {
		boolean answer = false;
		switch (this.operator) {
		case BETWEEN:
			if(cellValue >= this.min && cellValue <= this.max ) 
				answer = true;
			break;
		case EQUAL:
			if(cellValue == this.value)
				answer = true;
			break;
		case GE: 
			if(cellValue >= this.value) 
				answer = true;
			break;
		case GT:
			if(cellValue > this.value)
				answer = true;
			break;
		case LE:
			if(cellValue <= this.value)
				answer = true;
			break;
		case LT:
			if(cellValue < this.value)
				answer = true;
			break;
		case NOT_BETWEEN:
			if(cellValue > this.max || cellValue < this.min)
				answer = true;
			break;
		case NOT_EQUAL:
			if(cellValue != this.value)
				answer = true;
			break;
		}
		return answer;
	}

}
