/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: Junit test cases to test the PropertyDriver class.
 * Due: 10/26/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to another student.
 * Name and Signature: Joseph Mark Costa
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PropertyDriverJUnitTestStudent {

	@BeforeAll
	static void beforeAll(){
		PropertyDriver.main(null);
	}
	
	@Test
	void testPropertiesCount() {	
		assertEquals(2, PropertyDriver.company.getPropertyCount());		
	}
	
	@Test
	void testTotalRent() {
		assertEquals(500.50, PropertyDriver.company.totalRent());		
	}

}
