/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: This class is used to make the Company and add Properties to it.
 * Due: 10/26/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to another student.
 * Name and Signature: Joseph Mark Costa
 */

/**
 * This class represents the management company blueprint.
 * It is an aggregate class as it holds an array of Properties.
 */
public class ManagementCompany {

	private String name;
	private String taxId;
	private Property[] properties;
	private int propertyCount;
	
	public ManagementCompany(String name, String taxId, int propertyCount) {
		this.name = name;
		this.taxId = taxId;
		this.properties = new Property[10];
		this.propertyCount = propertyCount;
	}
	
	/**
	 * Constructor that is used to create a deep copy of a company.
	 * @param company Company Object to Copy
	 */
	public ManagementCompany(ManagementCompany company) {
		this.name = company.name;
		this.taxId = company.taxId;
		
		this.properties = new Property[company.properties.length];
		for(int i = 0; i < properties.length; i++) {
			if(company.properties[i] != null) {
				properties[i] = new Property(company.properties[i]);
			}
		}
		
		this.propertyCount = company.propertyCount;
	}
	
	/**
	 * Adds a Property to the properties Array.
	 * If the current index is null, add the property.
	 * Else, move to the next one and check the same.
	 * @param p Property to Add.
	 * @return The index in the array where the property was added, else an error 404 number.
	 */
	public int addProperty(Property p) {
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				properties[i] = new Property(p);
				propertyCount++;
				return i;
			}
		}
		return 404;
	}
	
	/**
	 * Sums the total rent of the properties.
	 * @return The total rent.
	 */
	public double totalRent() {
		double sum = 0;
		for(Property p: properties) {
			if(p != null) {
				sum += p.getRentAmount();
			}	
		}
		return sum;
	}
	
	public int getPropertyCount() {
		return propertyCount;
	}
	
	public String toString() {
		String allProperties = "";
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				allProperties += ("\t" + i + ": " + properties[i].getPropertyName() + ", City: " + properties[i].getCity() + ", Rent: " + properties[i].getRentAmount() + ", Owner: " + properties[i].getOwner() + "\n");
			}
		}
		//return "Management Company: " + name + ", Tax-Id(" + taxId + ")\nProperties:\n" + allProperties + "Total Rent: $" + totalRent();
		return String.format("Management Company: " + name + ", Tax-Id(" + taxId + ")\nProperties:\n" + allProperties + "\nTotal Rent: $%,.2f", totalRent());
	}
	
}
