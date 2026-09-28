/**
 * This Patient class contains all the fields and methods needed to perform
 * operations on the Patient objects
 */
public class Patient {
	
	// Fields of the Patient Class
	// All are declared as Private
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;
	private String emergencyName;
	private String emergencyPhone;
	
	/**
	 * The No-Arg Constructor for Patient
	 * It initializes all variables to default values
	 * Strings are "Default", numeric data is 0
	 * 
	 * Data initialized to Default so that user would be 
	 * well aware when default constructor was used
	 */
	public Patient() {
		firstName = "Default";
		middleName = "Default";
		lastName = "Default";
		streetAddress = "Default";
		city = "Default";
		state = "Default";
		zipcode = "Default";
		phoneNumber = "Default";
		emergencyName = "Default";
		emergencyPhone = "Default";
	}
	
	/**
	 * This constructor is used to initialize first, middle, and last name
	 * @param f - First Name
	 * @param m - Middle Name
	 * @param l - Last Name
	 */
	public Patient(String f, String m, String l) {
		firstName = f;
		middleName = m;
		lastName = l;
	}

	/**
	 * This constructor is used to initialize all fields
	 * @param f - First Name
	 * @param m - Middle Name
	 * @param l - Last Name
	 * @param str - Street Address
	 * @param c - City
	 * @param sta - State
	 * @param zip - Zipcode
	 * @param phone - Phone Number
	 * @param eName - Emergency Contact Name
	 * @param ePhone - Emergency Contact Number
	 */
	public Patient(String f, String m, String l, String str, String c, String sta, 
			String zip, String phone, String eName, String ePhone) {
		firstName = f;
		middleName = m;
		lastName = l;
		streetAddress = str;
		city = c;
		state = sta;
		zipcode = zip;
		phoneNumber = phone;
		emergencyName = eName;
		emergencyPhone = ePhone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String f) {
		firstName = f;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String m) {
		middleName = m;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String l) {
		lastName = l;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String str) {
		streetAddress = str;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String c) {
		city = c;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String sta) {
		state = sta;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zip) {
		zipcode = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phone) {
		phoneNumber = phone;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String eName) {
		emergencyName = eName;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String ePhone) {
		emergencyPhone = ePhone;
	}
	
	/**
	 * Builds the full name of the Patient
	 * @return The concatenated full name of the Patient
	 */
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	/**
	 * Builds the full address of the Patient
	 * @return The complete address of the Patient as a String
	 */
	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipcode;
	}
	
	/**
	 * Builds the full emergency contact information
	 * @return The complete emergency contact profile
	 */
	public String buildEmergencyContact() {
		return emergencyName + " " + emergencyPhone;
	}
	
	/**
	 * This method determines whether or not the phone number is valid
	 * It checks to see how many hyphens and numbers the string contains
	 * Based on those, validity is determined
	 * @return A Boolean Value depending on Validity
	 */
	public boolean isValidPhoneNumber() {
		int hyphenCount = 0;
		int numberCount = 0;
		for(int i = 0; i < phoneNumber.length(); i++) {
			if(phoneNumber.charAt(i) == '-') {
				hyphenCount++;
			}
			if(Character.isDigit(phoneNumber.charAt(i))) {
				numberCount++;
			}
		}
		if(hyphenCount == 2 && numberCount == 10) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method determines whether or not the emergency phone number is valid
	 * It checks to see how many hyphens and numbers the string contains
	 * Based on those, validity is determined
	 * @return A Boolean Value depending on Validity
	 */
	public boolean isValidEmergencyPhoneNumber() {
		int hyphenCount = 0;
		int numberCount = 0;
		for(int i = 0; i < emergencyPhone.length(); i++) {
			if(emergencyPhone.charAt(i) == '-') {
				hyphenCount++;
			}
			if(Character.isDigit(emergencyPhone.charAt(i))) {
				numberCount++;
			}
		}
		if(hyphenCount == 2 && numberCount == 10) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Gets Last Name, First Name  Middle Name
	 * @return Last Name, First Name  Middle Name
	 */
	public String getLastFirstMiddle() {
		return lastName + ", " + firstName + " " + middleName;
	}
	
	/**
	 * Checks whether patient has matching city and state arguments
	 * @param nCity - City
	 * @param nState - State
	 * @return True if Patient matches city and state. False otherwise
	 */
	public boolean hasSameCityState(String nCity, String nState) {
		if(city.equalsIgnoreCase(nCity) && state.equalsIgnoreCase(nState)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Updates the whole address
	 * @param str - Street Address
	 * @param c - City
	 * @param sta - State
	 * @param zip - Zipcode
	 */
	public void updateAddress(String str, String c, String sta, String zip) {
		streetAddress = str;
		city = c;
		state = sta;
		zipcode = zip;
	}
	
	/**
	 * Gets the contact summary
	 * @return The contact sommary of the patient
	 */
	public String getContactSummary() {
		String summary = String.format("Contact Summary\nName: %-25s\nPhone: %-25s\n"
				+ "Emergency Phone: %-25s\n", getLastFirstMiddle(), getPhoneNumber(), getEmergencyPhone());
		return summary;
	}
	
	/**
	 * Returns complete Patient information
	 * @return Complete patient information
	 */
	public String toString() {
		String completePatientInformation = "Name: " + buildFullName() + "\n"
				+ "Address: " + buildAddress() + "\n"
				+ "Phone Number: " + phoneNumber + "\n"
				+ "Emergency Contact: " + buildEmergencyContact() + "\n"
				+ "Phone Valid: " + isValidPhoneNumber() + "\n"
				+ "Emergency Phone Valid: " + isValidEmergencyPhoneNumber();
		return completePatientInformation;
	}
	
}
