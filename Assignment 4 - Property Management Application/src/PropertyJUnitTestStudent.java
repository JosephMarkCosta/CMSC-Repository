/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: JUnit test cases to test the Property Class.
 * Due: 10/26/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to another student.
 * Name and Signature: Joseph Mark Costa
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PropertyJUnitTestStudent {
	
	@Test
	void testPropertyConstructorDefault() {
		Property property = new Property();
		assertEquals(null, property.getPropertyName());
		assertEquals(null, property.getCity());
		assertEquals(0.0, property.getRentAmount());
		assertEquals(null, property.getOwner());
	}
	
	@Test
	void testPropertyConstructorParameterized() {
		Property property = new Property("Property 1", "Rockville", 1000.50, "Joseph");
		assertEquals("Property 1", property.getPropertyName());
		assertEquals("Rockville", property.getCity());
		assertEquals(1000.50, property.getRentAmount());
		assertEquals("Joseph", property.getOwner());
	}
	
	@Test
	void testPropertyConstructorCopy() {
		Property property1 = new Property("Property 1", "Rockville", 1000.50, "Joseph");
		Property property2 = new Property(property1);
		assertEquals("Property 1", property2.getPropertyName());
		assertEquals("Rockville", property2.getCity());
		assertEquals(1000.50, property2.getRentAmount());
		assertEquals("Joseph", property2.getOwner());
	}

}
