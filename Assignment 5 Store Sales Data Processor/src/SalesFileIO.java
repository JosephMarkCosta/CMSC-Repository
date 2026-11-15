/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: Contains the Methods to Read and Write to a File
 * Due: 11/16/2026
 * Platform/Compiler: Eclipse Java IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Student Name and Signature: Joseph Mark Costa
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class contains methods to read the array data and to write the output to
 * a file.
 */
public class SalesFileIO {

	/**
	 * This method accepts a filename for input, processes the data and converts it into a usable double array.
	 * @param filename The name of the input file containing sales data
	 * @return A 2D double array containing sales data
	 * @throws FileNotFoundException
	 */
	public static double[][] readSalesData(String filename) throws FileNotFoundException {
		// Create the File and Scanner Objects to read Data from the file
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		double[][] ruggedArr;

		// Read each line
		// Find out how many rows are needed
		// Store in String
		// Tokenize String
		// Convert to Double
		// Store in Rugged Array

		// Find how many rows are needed
		// Then initialize rugged array with said number of rows
		// Input files generally have an empty row at the end
		// So if the last rows are empty, do not count them
		int rowCount = 0;
		while (scan.hasNextLine()) {
			String readLine = scan.nextLine();
			readLine = readLine.trim();
			if (!readLine.equals("")) {
				rowCount++;
			}
		}

		ruggedArr = new double[rowCount][];
		rowCount = 0;
		scan.close();
		// Re-initialize the scanner variable to start from the beginning again
		scan = new Scanner(file);

		// Now, Store the rest of the data
		while (scan.hasNextLine()) {
			// Store the first (and following) row/s in a string
			String data = scan.nextLine();
			// Trim and Tokenize the String
			data = data.trim();
			if (!data.equals("")) {
				String[] ruggedRow = data.split(" ");
				// Initialize the inner array
				ruggedArr[rowCount] = new double[ruggedRow.length];
				// Now, fill the inner arrays with data
				for (int i = 0; i < ruggedArr[rowCount].length; i++) {
					ruggedArr[rowCount][i] = Double.parseDouble(ruggedRow[i]);
				}
				// Now, continue to the next row and the data
				rowCount++;
			}
		}
		scan.close();
		return ruggedArr;
	}

	/**
	 * This method prints the calculated data to an output file
	 * @param filename Name of output file
	 * @param data A 2D double array containing sales data
	 * @throws FileNotFoundException
	 */
	public static void writeSummary(String filename, double[][] data) throws FileNotFoundException {
		// Create a PrintWriter object to store the data in a file
		// Use utility methods to calculate the results
		PrintWriter outputFile = new PrintWriter(filename);

		// Print the Total and Average Sales
		outputFile.printf("Total Sales: $%,.2f\n", SalesDataUtility.getTotal(data));
		outputFile.printf("Average Sales: $%,.2f\n", SalesDataUtility.getAverage(data));

		outputFile.println();

		// Use a for-loop to print the total in all rows and columns
		for (int i = 0; i < data.length; i++) {
			outputFile.printf("The Total in Row %d is: $%,.2f\n", i, SalesDataUtility.getRowTotal(data, i));
		}

		// Find the maximum number of columns
		int maxCol = 0;
		for (double[] arr : data) {
			if (arr.length > maxCol) {
				maxCol = arr.length;
			}
		}

		outputFile.println();

		// Print the Total in All Columns
		for (int i = 0; i < maxCol; i++) {
			outputFile.printf("The Total in Col %d is: $%,.2f\n", i, SalesDataUtility.getColumnTotal(data, i));
		}

		outputFile.println();

		// Use a for-loop to print the highest in all the rows
		for (int i = 0; i < data.length; i++) {
			outputFile.printf("The Highest in Row %d is: $%,.2f\n", i, SalesDataUtility.getHighestInRow(data, i));
		}

		outputFile.println();

		// Use a for-loop to print the lowest in all the rows
		for (int i = 0; i < data.length; i++) {
			outputFile.printf("The Lowest in Row %d is: $%,.2f\n", i, SalesDataUtility.getLowestInRow(data, i));
		}

		outputFile.println();

		// Print the Highest and Lowest Sale in the Array
		outputFile.printf("The Highest in The Array is: $%,.2f\n", SalesDataUtility.getHighestInArray(data));
		outputFile.printf("The Lowest in The Array is: $%,.2f", SalesDataUtility.getLowestInArray(data));

		outputFile.close();
	}

}
