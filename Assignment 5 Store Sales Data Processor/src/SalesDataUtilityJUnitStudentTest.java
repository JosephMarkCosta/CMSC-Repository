/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: Contains the JUnit Test Cases to Test Utility Methods.
 * Due: 11/16/2026
 * Platform/Compiler: Eclipse Java IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Student Name and Signature: Joseph Mark Costa
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This class contains JUnit test cases for the SalesDataUtility class methods
 */
class SalesDataUtilityJUnitStudentTest {

	static double[][] data;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		data = SalesFileIO.readSalesData("salesdata.txt");
	}

	@Test
	void testGetTotal() {
		// Only applicable with the current provided data - salesdata.txt
		assertEquals(1322.10, SalesDataUtility.getTotal(data));
	}

	@Test
	void testGetAverage() {
		// Only applicable with the current provided data - salesdata.txt
		// Because getAverage returns a double value that is rounded to 2 decimal places
		// It doesn't equal to 146.90 by default and must be formatted by String.format
		String expected = "146.90";
		String actual = String.format("%.2f", SalesDataUtility.getAverage(data));
		assertEquals(expected, actual);
	}

	@Test
	void testGetRowTotal() {
		// Only applicable with the current provided data - salesdata.txt
		assertEquals(451.25, SalesDataUtility.getRowTotal(data, 0));
		assertEquals(170.00, SalesDataUtility.getRowTotal(data, 1));
		assertEquals(700.85, SalesDataUtility.getRowTotal(data, 2));
	}

	@Test
	void testGetColumnTotal() {
		// Only applicable with the current provided data - salesdata.txt
		assertEquals(400.60, SalesDataUtility.getColumnTotal(data, 0));
		assertEquals(421.25, SalesDataUtility.getColumnTotal(data, 1));
		assertEquals(450.00, SalesDataUtility.getColumnTotal(data, 2));
		assertEquals(50.25, SalesDataUtility.getColumnTotal(data, 3));
	}

	@Test
	void testGetHighestInRow() {
		// Only applicable with the current provided data - salesdata.txt
		assertEquals(200.75, SalesDataUtility.getHighestInRow(data, 0));
		assertEquals(90.00, SalesDataUtility.getHighestInRow(data, 1));
		assertEquals(300.00, SalesDataUtility.getHighestInRow(data, 2));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(100.50, SalesDataUtility.getLowestInRow(data, 0));
		assertEquals(80.00, SalesDataUtility.getLowestInRow(data, 1));
		assertEquals(50.25, SalesDataUtility.getLowestInRow(data, 2));
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(300.00, SalesDataUtility.getHighestInArray(data));
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(50.25, SalesDataUtility.getLowestInArray(data));
	}

}
