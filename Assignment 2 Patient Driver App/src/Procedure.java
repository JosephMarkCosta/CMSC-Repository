/**
 * The Procedure class contains all the fields and methods of the Procedure objects
 */
public class Procedure {
	
	// Object fields are created
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double procedureCharge;
	
	/**
	 * Default Constructor
	 */
	public Procedure() {
		procedureName = "Empty Procedure";
		procedureDate = "XX/XX/XXXX";
		practitionerName = "No-Name";
		procedureCharge = 0.0;
	}
	
	/**
	 * Constructor to initialize Procedure name and Date
	 * @param procName - Procedure Name
	 * @param procDate - Procedure Date
	 */
	public Procedure(String procName, String procDate) {
		procedureName = procName;
		procedureDate = procDate;
		practitionerName = "No-Name";
		procedureCharge = 0.0;
	}

	/**
	 * Constructor to initialize all attributes
	 * @param procName - Procedure Name
	 * @param procDate - Procedure Date
	 * @param pracName - Practitioner Name
	 * @param procCharge - Practitioner Charge
	 */
	public Procedure(String procName, String procDate, String pracName, double procCharge) {
		procedureName = procName;
		procedureDate = procDate;
		practitionerName = pracName;
		procedureCharge = procCharge;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procName) {
		procedureName = procName;
	}

	public String getProcedureDate() {
		return procedureDate;
	}

	public void setProcedureDate(String procDate) {
		procedureDate = procDate;
	}

	public String getPractitionerName() {
		return practitionerName;
	}

	public void setPractitionerName(String pracName) {
		practitionerName = pracName;
	}

	public double getProcedureCharge() {
		return procedureCharge;
	}

	public void setProcedureCharge(double procCharge) {
		procedureCharge = procCharge;
	}
	
	public String toString() {
		return String.format("Procedure: %s, Date: %s, Practioner: %s, Charge: $%.2f",
				procedureName, procedureDate, practitionerName, procedureCharge);
	}
	
	/**
	 * Finds whether or not a procedure is expensive
	 * @return True or False
	 */
	public boolean isExpensiveProcedure() {
		if(procedureCharge >= 1000.00) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Applies a discount to calculate new charges
	 * @param percent - Discount percent
	 */
	public void applyDiscount(double percent) {
		if(percent >= 0 && percent <= 100) {
			procedureCharge -= procedureCharge * (percent/100);
			System.out.printf("Discount of %.2f percent has been applied.\n", percent);
		}else {
			System.out.println("Discount not valid. Please enter a discount of 0-100 percent.");
		}
	}
	
	/**
	 * Returns charge category
	 * @return High, Medium, or Low
	 */
	public String getChargeCategory() {
		if(procedureCharge >= 0 && procedureCharge <=400) {
			return "Low";
		}else if(procedureCharge >300 && procedureCharge <=800) {
			return "Medium";
		}else {
			return "High";
		}
	}
	
	/**
	 * Checks whether or not practitioner is matching
	 * @param pracName - Practitioner Name
	 * @return True or False
	 */
	public boolean isPerformedBy(String pracName) {
		if(practitionerName.equalsIgnoreCase(pracName)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Formats the price in easy to read format
	 * @return Formatted Price with String.format
	 */
	public String getFormattedCharge() {
		return String.format("$%,.2f", procedureCharge);
	}
	
	

}
