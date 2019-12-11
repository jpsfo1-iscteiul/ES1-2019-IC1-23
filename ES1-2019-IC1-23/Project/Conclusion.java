

public class Conclusion {
	
	private Classifier classifier;
	private Boolean result;
	
	public Conclusion(Classifier classifier, Boolean result) {
		this.classifier = classifier;
		this.result = result; 
	}
	
	@Override
	public String toString() {
		return(classifier + " IS " + result.toString().toUpperCase());
	}
	
	public Classifier getClassifier() {
		return classifier;
	}
	
	public Boolean getResult() {
		return result;
	}

}
