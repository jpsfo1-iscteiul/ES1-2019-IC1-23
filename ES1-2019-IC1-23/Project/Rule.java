import java.util.List;

public class Rule {


	private List<Premisse> premisses;
	private Conclusion conclusion;

	public Rule(List<Premisse> premisses, Conclusion conclusion) {
		this.premisses = premisses;
		this.conclusion = conclusion;
	}

	@Override
	public String toString() {
		StringBuilder ab = new StringBuilder();
		ab.append("IF ( ");
		for(int i = 0; i < premisses.size() ; i++) {
			ab.append(premisses.get(i).toString());
			if(i!= premisses.size()-1)
				ab.append("E ");
		}
		ab.append(") THEN ");
		ab.append(conclusion.toString());
		return(ab.toString());
	}
	
	public List<Premisse> getPremisses() {
		return premisses;
	}
	
	public Conclusion getConclusion() {
		return conclusion;
	}

}
