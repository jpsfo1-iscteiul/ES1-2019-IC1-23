package pack;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
//import java.util.List;

/**
 * The Class Rule.
 */
public class Rule {


/** The premisse 1. */
//	private List<Premisse> premisses;
	private Premisse premisse1;
	
	/** The premisse 2. */
	private Premisse premisse2;
	
	/** The and or. */
	private String andOr;
	
	/** The conclusion. */
	private Conclusion conclusion;
	
	/** The name. */
	private String name;

//	public Rule(List<Premisse> premisses, Conclusion conclusion) {
//		this.premisses = premisses;
//		this.conclusion = conclusion;
//	}
	
	/**
 * Instantiates a new rule.
 *
 * @param name the name
 * @param premisse1 the premisse 1
 * @param premisse2 the premisse 2
 * @param andOr the and or
 * @param conclusion the conclusion
 */
public Rule(String name, Premisse premisse1, Premisse premisse2, String andOr, Conclusion conclusion) {
		this.name = name;
		this.premisse1 = premisse1;
		this.premisse2 = premisse2;
		this.andOr = andOr;
		this.conclusion = conclusion;
	}
	
	/**
	 * Instantiates a new rule.
	 *
	 * @param name the name
	 * @param premisse1 the premisse 1
	 * @param conclusion the conclusion
	 */
	public Rule(String name, Premisse premisse1, Conclusion conclusion ) {
		this.andOr = "";
		this.name = name;
		this.premisse1 = premisse1;
		this.conclusion = conclusion;
	}
	
	/**
	 * Gets the result.
	 *
	 * @param cellValue1 the cell value 1
	 * @param cellValue2 the cell value 2
	 * @return the result
	 */
	public Boolean getResult(double cellValue1, double cellValue2) {
		boolean answer = !getConclusion().getResult();
		if(andOr.equals("AND")) 
			if(premisse1.isTrue(cellValue1) && premisse2.isTrue(cellValue2))
				answer = getConclusion().getResult();
		if(andOr.equals("OR"))
			if(premisse1.isTrue(cellValue1) || premisse2.isTrue(cellValue2))
				answer = getConclusion().getResult();
		
		return answer;
	}
	
	/**
	 * Gets the result.
	 *
	 * @param cellValue the cell value
	 * @return the result
	 */
	public Boolean getResult(double cellValue) {
		if(premisse1.isTrue(cellValue))
			return getConclusion().getResult();
		return !getConclusion().getResult();
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
		public String toString() {
			return this.name;
		}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
//	@Override
//	public String toString() {
//		StringBuilder ab = new StringBuilder();
//		ab.append("IF ( ");
//		for(int i = 0; i < premisses.size() ; i++) {
//			ab.append(premisses.get(i).toString());
//			if(i!= premisses.size()-1)
//				ab.append("E ");
//		}
//		ab.append(") THEN ");
//		ab.append(conclusion.toString());
//		return(ab.toString());
//	}
	
//	public List<Premisse> getPremisses() {
//		return premisses;
//	}
	
	
	/**
 * Gets the conclusion.
 *
 * @return the conclusion
 */
public Conclusion getConclusion() {
		return conclusion;
	}

	/**
	 * Gets the premisse 1.
	 *
	 * @return the premisse 1
	 */
	public Premisse getPremisse1() {
		return premisse1;
	}
	
	/**
	 * Gets the premisse 2.
	 *
	 * @return the premisse 2
	 */
	public Premisse getPremisse2() {
		return premisse2;
	}
	
	/**
	 * Gets the and or.
	 *
	 * @return the and or
	 */
	public String getAndOr() {
		return andOr;
	}
}
