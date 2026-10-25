/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: JUnit test cases to test the ManagementCompany class.
 * Due: 10/26/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to another student.
 * Name and Signature: Joseph Mark Costa
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyJUnitTestStudent {

	ManagementCompany company;

	@BeforeEach
	void setUp() throws Exception {
		company = new ManagementCompany("Joseph's Company", "123-456-789", 0);
	}

	@AfterEach
	void tearDown() throws Exception {
		company = null;
	}

	@Test
	void testAddingProperties() {
		Property property1 = new Property("Property 1", "Rockville", 1400.00, "Joseph");
		Property property2 = new Property("Property 2", "Silver Spring", 1200.85, "Michael");
		Property property3 = new Property("Property 3", "Tacoma Park", 2344.43, "Jasper");

		assertEquals(0, company.addProperty(property1));
		assertEquals(1, company.addProperty(property2));
		assertEquals(2, company.addProperty(property3));

	}
	
	@Test
	void testTotalRent() {
		Property property1 = new Property("Property 1", "Rockville", 1400.00, "Joseph");
		Property property2 = new Property("Property 2", "Silver Spring", 1200.85, "Michael");
		Property property3 = new Property("Property 3", "Tacoma Park", 2344.43, "Jasper");

		company.addProperty(property1);
		company.addProperty(property2);
		company.addProperty(property3);
		
		assertEquals(4945.28, company.totalRent());

	}

}
