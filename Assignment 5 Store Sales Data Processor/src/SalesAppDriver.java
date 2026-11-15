/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: Contains the Console Driver Class
 * Due: 11/16/2026
 * Platform/Compiler: Eclipse Java IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Student Name and Signature: Joseph Mark Costa
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * This class serves as the console driver for the Sales Processor Program
 */
public class SalesAppDriver {

	public static void main(String[] args) throws IOException {
		// Accept the Filenames from the user and send it to SalesFileIO
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Name of the Input File:");
		String inputfile = scan.nextLine();
		System.out.println("Enter the Name of the Output File:");
		String outputFile = scan.nextLine();

		// SalesFileIO accepts the data and uses SalesDataUtility to compute the results
		// SalesFileIO saves the data into the output file
		double[][] data = SalesFileIO.readSalesData(inputfile);
		SalesFileIO.writeSummary(outputFile, data);

		System.out.println("File Read Successfully and Data Saved in Output File.");
		scan.close();

	}

}
