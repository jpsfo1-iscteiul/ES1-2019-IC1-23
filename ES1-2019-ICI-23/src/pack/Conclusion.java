package pack;

// TODO: Auto-generated Javadoc
/**
 * The Class Conclusion.
 */
public class Conclusion {
	
	/** The classifier. */
	private Classifier classifier;
	
	/** The result. */
	private Boolean result;
	
	/**
	 * Instantiates a new conclusion.
	 *
	 * @param classifier the classifier
	 * @param result the result
	 */
	public Conclusion(Classifier classifier, Boolean result) {
		this.classifier = classifier;
		this.result = result; 
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return(classifier + " IS " + result.toString().toUpperCase());
	}
	
	/**
	 * Gets the classifier.
	 *
	 * @return the classifier
	 */
	public Classifier getClassifier() {
		return classifier;
	}
	
	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Boolean getResult() {
		return result;
	}

}
