/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: Contains the Utility Methods to Perform Operations
 * Due: 11/16/2026
 * Platform/Compiler: Eclipse Java IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Student Name and Signature: Joseph Mark Costa
 */

/**
 * This class contains the utility methods needed to perform operations on the Sales Data Array
 */
public class SalesDataUtility {
	
	/**
	 * This method calculates the total sales from the array by summing the data from each row and column
	 * @param data double 2d sales array
	 * @return The total of the entire array
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;
		for(double[] arr: data) {
			for(double sales: arr) {
				total += sales;
			}
		}
		return total;
	}
	
	/**
	 * Calculates the Average Sales of the entire array
	 * @param data The 2d double array representing sales
	 * @return The average sale of the array
	 */
	public static double getAverage(double[][] data) {
		// First, find out how many items are in the array by summing the length of each inner array
		int numOfItems = 0;
		for(double[] arr: data) {
			numOfItems += arr.length;
		}
		// Now, get the total by executing getTotal() and divide by numOfItems to get the average
		double averageSale = getTotal(data) / numOfItems;
		return averageSale;
	}
	
	/**
	 * Returns the total value of a given row
	 * @param data Represents the given 2d double sales array
	 * @param row Represents the given row whose total is to be calculated
	 * @return The total sales of the given row
	 */
	public static double getRowTotal(double[][] data, int row) {
		// Calculate the total of a given row and return it
		double total = 0.0;
		for(int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}
	
	/**
	 * This method finds the total sales of a given column
	 * If a column doesn't exists in a row, that row is skipped
	 * @param data Represents the 2d sales array
	 * @param col Represents the column whose total is to be calculated
	 * @return The total of the given column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		// Calculate the total sales of a given column
		// If the column doesn't exist in a row, skip that row
		// We can check whether the column exists by checking if the 
		// column is less than or equal to the inner array length - 1
		double total = 0.0;
		for(int i = 0; i < data.length; i++) {
			if(col <= data[i].length-1) {
				total += data[i][col];
			}else {
				continue;
			}
		}
		return total;
	}
	
	/**
	 * This method returns the highest value in a given row
	 * @param data Represents the 2d sales array
	 * @param row Represents the row whose highest is to be calculated
	 * @return The highest value in the given row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		// Calculate the highest value in a given row
		double highest = 0.0;
		for(double sale: data[row]) {
			if(sale > highest) {
				highest = sale;
			}
		}
		return highest;
	}
	
	/**
	 * Find the Lowest Value in a Given Row
	 * @param data Represents the 2d sales array
	 * @param row Represents the given row whose lowest we are to find
	 * @return The lowest value in a given row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		// Calculate the lowest value in a given row
		double lowest = data[row][0];
		for(double sale: data[row]) {
			if(sale < lowest) {
				lowest = sale;
			}
		}
		return lowest;
	}
	
	/**
	 * Find the Highest Value in the Sales Array
	 * @param data The 2D Sales Array
	 * @return The Highest Value in the Array
	 */
	public static double getHighestInArray(double[][] data) {
		// We can find the highest in the array by using a for-loop and an if statement
		double highest = 0.0;
		for(double[] arr: data) {
			for(double sale: arr) {
				if(sale > highest) {
					highest = sale;
				}
			}
		}
		return highest;
	}
	
	/**
	 * Finds the Lowest Value in the Array
	 * @param data The 2D Sales Array
	 * @return The Lowest Value in the Array
	 */
	public static double getLowestInArray(double[][] data) {
		// We can find the lowest in the array by using a for-loop and an if statement
		double lowest = data[0][0];
		for(double[] arr: data) {
			for(double sale: arr) {
				if(sale < lowest) {
					lowest = sale;
				}
			}
		}
		return lowest;
	}

}
