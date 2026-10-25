/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: This class is used to make the Property Objects.
 * Due: 10/26/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to another student.
 * Name and Signature: Joseph Mark Costa
 */

/**
 * The Property Class is used to make the Property Objects.
 * It has its instance fields as well as a copy constructor.
 */
public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	
	public Property() {
		// TODO Auto-generated constructor stub
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	/**
	 * Copy Constructor that is used to create a copy of the Property Object
	 * @param property Property Object to Copy
	 */
	public Property(Property property) {
		this.propertyName = property.propertyName;
		this.city = property.city;
		this.rentAmount = property.rentAmount;
		this.owner = property.owner;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String toString() {
		return "Property Name: " + propertyName + 
				"\nCity: " + city + 
				"\nRent Amount" + rentAmount + 
				"\nOwner: " + owner;
	}

}
