package pack;

public class Row {
	
	private int methodID;
	private String packageName;
	private String className;
	private String method;
	private int loc;
	private int cyclo;
	private int atdf;
	private double laa;
	private boolean iPlasma;
	private boolean isFeatureEnvy;
	private boolean pmd;
	private boolean isLongMethod;
	
	
	public Row(int methodID, String packageName, String className, String method, int loc, int cyclo, int atdf, double laa, boolean isLongMethod, boolean iPlasma, boolean pmd, boolean isFeatureEnvy) {
		super();
		this.methodID = methodID;
		this.packageName = packageName;
		this.className = className;
		this.method = method;
		this.loc = loc;
		this.cyclo = cyclo;
		this.atdf = atdf;
		this.laa = laa;
		this.isLongMethod=isLongMethod;
		this.iPlasma= iPlasma;
		this.pmd = pmd;
		this.isFeatureEnvy=isFeatureEnvy;
	}
	
	public boolean getIPlasma() {
		return iPlasma;
	}
	public boolean getIsFeatureEnvy() {
		return isFeatureEnvy;
	}
	public boolean getIsLongMethod() {
		return isLongMethod;
	}
	

	public int getMethodID() {
		return methodID;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getClassName() {
		return className;
	}

	public String getMethod() {
		return method;
	}

	public int getLoc() {
		return loc;
	}

	public int getCyclo() {
		return cyclo;
	}

	public int getAtdf() {
		return atdf;
	}

	public double getLaa() {
		return laa;
	}
	
	public boolean getPmd(){
		return pmd;
	}

	@Override
	public String toString() {
		return "Row [methodID=" + methodID + ", packageName=" + packageName + ", className=" + className + ", method="
				+ method + ", loc=" + loc + ", cyclo=" + cyclo + ", atdf=" + atdf + ", laa=" + laa + "isLongMethod="+isLongMethod+"]";
	}
	
}
