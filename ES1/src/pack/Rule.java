package pack;

import java.util.ArrayList;

//import java.util.List;

public class Rule {


//	private List<Premisse> premisses;
	private Premisse premisse1;
	private Premisse premisse2;
	private String andOr;
	private Conclusion conclusion;
	private String name;

//	public Rule(List<Premisse> premisses, Conclusion conclusion) {
//		this.premisses = premisses;
//		this.conclusion = conclusion;
//	}
	
	public Rule(String name, Premisse premisse1, Premisse premisse2, String andOr, Conclusion conclusion) {
		this.name = name;
		this.premisse1 = premisse1;
		this.premisse2 = premisse2;
		this.andOr = andOr;
		this.conclusion = conclusion;
	}
	
	public Rule(String name, Premisse premisse1, Conclusion conclusion ) {
		this.andOr = "";
		this.name = name;
		this.premisse1 = premisse1;
		this.conclusion = conclusion;
	}
	
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
	
	public Boolean getResult(double cellValue) {
		if(premisse1.isTrue(cellValue))
			return getConclusion().getResult();
		return !getConclusion().getResult();
	}
	
	@Override
		public String toString() {
			return this.name;
		}
	
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
	
	
	public Conclusion getConclusion() {
		return conclusion;
	}

	public Premisse getPremisse1() {
		return premisse1;
	}
	
	public Premisse getPremisse2() {
		return premisse2;
	}
	
	public String getAndOr() {
		return andOr;
	}
}
