/* 
 * Class: CMSC203
 * Instructor: Dr. Huseyin Aygun
 * Description: The Implementation of Assignment 2. 
 *              It contains the full Patient Driver Application and has 3 classes
 * Due: 09/28/2026
 * Platform/Compiler - Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student
 * Name and Signature: Joseph Mark Costa
 */

import java.util.Scanner;


/**
 * The PatientDriverApp class
 * It contains the main method which starts program execution
 */
public class PatientDriverApp {

	public static void main(String[] args) {
		
		/*
		 * Creates a Scanner object to accept input
		 * Creates a patient object
		 * Creates 3 procedures
		 * Calls the necessary static methods to perform operation
		 */
		Scanner scan = new Scanner(System.in);
		Patient patient = new Patient();
		patient = inputPatient(scan);
		displayPatient(patient);
		System.out.println();
		Procedure procedure1 = createProcedure1();
		//procedure1.applyDiscount(10);
		Procedure procedure2 = createProcedure2();
		//procedure2.setProcedureCharge(2000);
		Procedure procedure3 = createProcedure3();
		displayProcedureTable(procedure1, procedure2, procedure3);
		System.out.println();
		displaySummary(procedure1, procedure2, procedure3);
		System.out.println("\nThis program was developed by a Student: Joseph Mark Costa 09/28/2026");
		

	}
	
	/**
	 * This method accepts user input for a patient object
	 * @param input - Scanner object reference
	 * @return A patient object
	 */
	public static Patient inputPatient(Scanner input) {
		Patient patient = new Patient();
		System.out.println("Enter first name: ");
		patient.setFirstName(input.nextLine());
		System.out.println("Enter middle name: ");
		patient.setMiddleName(input.nextLine());
		System.out.println("Enter last name: ");
		patient.setLastName(input.nextLine());
		System.out.println("Enter street address: ");
		patient.setStreetAddress(input.nextLine());
		System.out.println("Enter city: ");
		patient.setCity(input.nextLine());
		System.out.println("Enter state: ");
		patient.setState(input.nextLine());
		System.out.println("Enter zip: ");
		patient.setZipcode(input.nextLine());
		System.out.println("Enter phone number (###-###-####): ");
		patient.setPhoneNumber(input.nextLine());
		System.out.println("Enter emergency contact name: ");
		patient.setEmergencyName(input.nextLine());
		System.out.println("Enter emergency contact phone: ");
		patient.setEmergencyPhone(input.nextLine());
		System.out.println();
		return patient;
	}
	
	/**
	 * Displays patient information by calling the toString
	 * @param patient - Patient object reference
	 */
	public static void displayPatient(Patient patient) {
		System.out.println("Patient Information");
		System.out.println("---------------------------");
		System.out.println(patient.toString());
	}
	/**
	 * Creates a Procedure using the Default Constructor
	 * Uses the setters to set the attributes because the default constructor doesn't do that
	 * @return Procedure object 1
	 */
	public static Procedure createProcedure1() {
		Procedure procedure1 = new Procedure();
		procedure1.setProcedureName("Physical Exam");
		procedure1.setProcedureDate("07/20/2026");
		procedure1.setPractitionerName("Dr. Irvine");
		procedure1.setProcedureCharge(250.00);
		return procedure1;
	}
	
	/**
	 * Uses the second constructor which initializes procedure name and date to create the procedure object
	 * Uses setters to initialize the other attributes
	 * @return Procedure object 2
	 */
	public static Procedure createProcedure2() {
		Procedure procedure2 = new Procedure("X-ray", "07/20/2026");
		procedure2.setPractitionerName("Dr. Jamison");
		procedure2.setProcedureCharge(550.43);
		return procedure2;
	}
	
	/**
	 * Uses the third constructor to initialize all attributes
	 * No setters required
	 * @return Procedure object 3
	 */
	public static Procedure createProcedure3() {
		Procedure procedure3 = new Procedure("Blood Test", "07/20/2026", "Dr. Smith", 1400.75);
		return procedure3;
	}
	
	/**
	 * This statement is used to display an individual procedure
	 * @param procedure - A Procedure object reference
	 */
	public static void displayProcedure(Procedure procedure) {
		System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n",
				procedure.getProcedureName(),
				procedure.getProcedureDate(),
				procedure.getPractitionerName(),
				procedure.getFormattedCharge(),
				procedure.getChargeCategory());
	}
	
	/**
	 * Displays a procedure table by calling the displayProcedure method 3 times
	 * @param p1 - Procedure 1
	 * @param p2 - Procedure 2
	 * @param p3 - Procedure 3
	 */
	public static void displayProcedureTable(Procedure p1, Procedure p2, Procedure p3) {
		System.out.println("Procedure\tDate\t\tPractitioner\tCharge\t\tCategory");
		System.out.println("-------------------------------------------------------------------------------");
		displayProcedure(p1);
		displayProcedure(p2);
		displayProcedure(p3);
	}
	
	/**
	 * Calculates total charges
	 * @param p1 - Procedure 1
	 * @param p2 - Procedure 2
	 * @param p3 - Procedure 3
	 * @return - Total Charges
	 */
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		double total = p1.getProcedureCharge() + p2.getProcedureCharge() + p3.getProcedureCharge();
		return total;
	}
	
	/**
	 * Calculates average charges
	 * @param p1 - Procedure 1
	 * @param p2 - Procedure 2
	 * @param p3 - Procedure 3
	 * @return Average charge
	 */
	public static double calculateAverageCharges(Procedure p1, Procedure p2, Procedure p3) {
		double average = (p1.getProcedureCharge() + p2.getProcedureCharge() + p3.getProcedureCharge()) / 3;
		return average;
	}
	
	/**
	 * Finds the most expensive Procedure
	 * @param p1 - Procedure 1
	 * @param p2 - Procedure 2
	 * @param p3 - Procedure 3
	 * @return The most expensive Procedure
	 */
	public static Procedure findHighestChargeProcedure(Procedure p1, Procedure p2, Procedure p3) {
		Procedure mostExpensive = null;
		double p1Price = p1.getProcedureCharge();
		double p2Price = p2.getProcedureCharge();
		double p3Price = p3.getProcedureCharge();
		
		if(p1Price > p2Price) {
			mostExpensive = p1;
		}else {
			mostExpensive = p2;
		}
		
		if(mostExpensive.getProcedureCharge() < p3Price) {
			mostExpensive = p3;
		}
		
		return mostExpensive;
		
	}
	
	
	/**
	 * Counts how many tests are expensive
	 * @param p1 - Procedure 1
	 * @param p2 - Procedure 2
	 * @param p3 - Procedure 3
	 * @return The number of expensive procedures
	 */
	public static int countExpensiveProcedures(Procedure p1, Procedure p2, Procedure p3) {
		int count = 0;
		if(p1.isExpensiveProcedure()) {
			count++;
		}
		if(p2.isExpensiveProcedure()) {
			count++;
		}
		if(p3.isExpensiveProcedure()) {
			count++;
		}
		return count;
	}
	
	/**
	 * Displays all the necessary summary
	 * @param p1 - Procedure 1
	 * @param p2 - Procedure 2
	 * @param p3 - Procedure 3
	 */
	public static void displaySummary(Procedure p1, Procedure p2, Procedure p3) {
		System.out.printf("Total Charges: $%,.2f\n", calculateTotalCharges(p1, p2, p3));
		System.out.printf("Average Charge: $%,.2f\n", calculateAverageCharges(p1, p2, p3));
		System.out.println("Highest Charge Procedure: " + findHighestChargeProcedure(p1, p2, p3).getProcedureName());
		System.out.println("Number of Expensive Procedures: " + countExpensiveProcedures(p1, p2, p3));
	}
	
	

}
