package File_Components;

public class Row {
	
	private int methodID;
	private String packageName;
	private String className;
	private String method;
	private int loc;
	private int cyclo;
	private int atdf;
	private double laa;
	
	public Row(int methodID, String packageName, String className, String method, int loc, int cyclo, int atdf, double laa) {
		super();
		this.methodID = methodID;
		this.packageName = packageName;
		this.className = className;
		this.method = method;
		this.loc = loc;
		this.cyclo = cyclo;
		this.atdf = atdf;
		this.laa = laa;
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

	@Override
	public String toString() {
		return "Row [methodID=" + methodID + ", packageName=" + packageName + ", className=" + className + ", method="
				+ method + ", loc=" + loc + ", cyclo=" + cyclo + ", atdf=" + atdf + ", laa=" + laa + "]";
	}
	
}
