package pack;

// TODO: Auto-generated Javadoc
/**
 * The Class Row.
 */
public class Row {
	
	/** The method ID. */
	private int methodID;
	
	/** The package name. */
	private String packageName;
	
	/** The class name. */
	private String className;
	
	/** The method. */
	private String method;
	
	/** The loc. */
	private int loc;
	
	/** The cyclo. */
	private int cyclo;
	
	/** The atdf. */
	private int atdf;
	
	/** The laa. */
	private double laa;
	
	/** The i plasma. */
	private boolean iPlasma;
	
	/** The is feature envy. */
	private boolean isFeatureEnvy;
	
	/** The pmd. */
	private boolean pmd;
	
	/** The is long method. */
	private boolean isLongMethod;
	
	
	/**
	 * Instantiates a new row.
	 *
	 * @param methodID the method ID
	 * @param packageName the package name
	 * @param className the class name
	 * @param method the method
	 * @param loc the loc
	 * @param cyclo the cyclo
	 * @param atdf the atdf
	 * @param laa the laa
	 * @param isLongMethod the is long method
	 * @param iPlasma the i plasma
	 * @param pmd the pmd
	 * @param isFeatureEnvy the is feature envy
	 */
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
	
	/**
	 * Gets the i plasma.
	 *
	 * @return the i plasma
	 */
	public boolean getIPlasma() {
		return iPlasma;
	}
	
	/**
	 * Gets the checks if is feature envy.
	 *
	 * @return the checks if is feature envy
	 */
	public boolean getIsFeatureEnvy() {
		return isFeatureEnvy;
	}
	
	/**
	 * Gets the checks if is long method.
	 *
	 * @return the checks if is long method
	 */
	public boolean getIsLongMethod() {
		return isLongMethod;
	}
	

	/**
	 * Gets the method ID.
	 *
	 * @return the method ID
	 */
	public int getMethodID() {
		return methodID;
	}

	/**
	 * Gets the package name.
	 *
	 * @return the package name
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Gets the loc.
	 *
	 * @return the loc
	 */
	public int getLoc() {
		return loc;
	}

	/**
	 * Gets the cyclo.
	 *
	 * @return the cyclo
	 */
	public int getCyclo() {
		return cyclo;
	}

	/**
	 * Gets the atdf.
	 *
	 * @return the atdf
	 */
	public int getAtdf() {
		return atdf;
	}

	/**
	 * Gets the laa.
	 *
	 * @return the laa
	 */
	public double getLaa() {
		return laa;
	}
	
	/**
	 * Gets the pmd.
	 *
	 * @return the pmd
	 */
	public boolean getPmd(){
		return pmd;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Row [methodID=" + methodID + ", packageName=" + packageName + ", className=" + className + ", method="
				+ method + ", loc=" + loc + ", cyclo=" + cyclo + ", atdf=" + atdf + ", laa=" + laa + "isLongMethod="+isLongMethod+"]";
	}
	
}
