public class Premisse {
	
	private Metric metric;
	private ComparisonOperator operator;
	private double value;
	private double min;
	private double max;
	
	public Premisse(Metric metric, ComparisonOperator operator, double value) {
		this.metric = metric;
		this.operator = operator;
		this.value = value;
	}
	
	public Premisse(Metric metric, ComparisonOperator operator, double min, double max) {
		this.metric = metric;
		this.operator = operator;
		this.min = min;
		this.max = max;
	}
	
	
	@Override
	public String toString() {
		if(operator.equals(ComparisonOperator.BETWEEN) || operator.equals(ComparisonOperator.NOT_BETWEEN))
			return(metric + " " + operator + " " + min + " AND " + max + " ");
		return(metric + " " + operator + " " + value + " ");
		
	}
	
	public Metric getMetric() {
		return metric;
	}
	
	public ComparisonOperator getOperator() {
		return operator;
	}
	
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
