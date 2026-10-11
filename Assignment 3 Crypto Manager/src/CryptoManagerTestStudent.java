import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 23011
 * Student: Joseph Mark Costa
 * Instructor: Dr. Huseyin Aygun
 * Description: This class contains all the completed methods for encryption and decryption
 * Due: 10/12/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming  assignment independently. 
 *  I have not copied the code from a student or any source. 
 *  I have not given my code to any student.
 *  Signature: Joseph Mark Costa
 */

class CryptoManagerTestStudent {
	
	// These are custom tests made by me to test all the methods of CryptoManager class

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("THIS STRING IS IN BOUNDS"));
		assertFalse(CryptoManager.isStringInBounds("this string is not in bounds"));
	}

	@Test
	void testVigenereEncryption() {
		assertEquals(
				"QS3P3'529PS",
				CryptoManager.vigenereEncryption("HELLO WORLD", "JOSEPH"),
				"This test failed because Strings do not match."
				);
		assertEquals(
				"The selected string is not in bounds. Try again.",
				CryptoManager.vigenereEncryption("hello world", "JOSEPH"),
				"Test failed. Check encryption method for errors."
				);
	}

	@Test
	void testVigenereDecryption() {
		assertEquals(
				"NICE WORK JOSEPH!",
				CryptoManager.vigenereDecryption(CryptoManager.vigenereEncryption("NICE WORK JOSEPH!", "JOSEPH"), "JOSEPH"),
				"Test failed. Check method."
				);
		assertNotEquals(
				"THIS STRING DOES NOT MATCH",
				CryptoManager.vigenereDecryption(CryptoManager.vigenereEncryption("HELLO WORLD", "JOSEPH"), "JOSEPH"),
				"Test failed. Check method."
				);
	}

	@Test
	void testPlayfairEncryption() {
		assertEquals(
				"APMMP7QAWFMQ",
				CryptoManager.playfairEncryption("HELLO WORLD", "JOSEPH"),
				"Test failed because encrypted Strings do not match."
				);
		assertEquals(
				"The selected string is not in bounds. Try again.",
				CryptoManager.playfairEncryption("abcd", "JOSEPH"),
				"Test failed because string is in bounds."
				);
	}

	@Test
	void testPlayfairDecryption() {
		assertEquals(
				"HELLO WORLD",
				CryptoManager.playfairDecryption(CryptoManager.playfairEncryption("HELLO WORLD", "JOSEPH"), "JOSEPH"),
				"TEST Failed because Strings do not match."
				);
		assertNotEquals(
				"MILKY WAY GALAXY",
				CryptoManager.playfairDecryption(CryptoManager.playfairEncryption("HELLO WORLD", "JOSEPH"), "JOSEPH"),
				"TEST FAILED BECAUSE STRINGS ARE MATCHING."
				);
	}

	@Test
	void testCaesarEncryption() {
		assertEquals(
				"OLSSV'^VYSK",
				CryptoManager.caesarEncryption("HELLO WORLD", 7),
				"Test failed because Strings do not match"
				);
		assertEquals(
				"The selected string is not in bounds. Try again.",
				CryptoManager.caesarEncryption("hello world", 7),
				"Test failed because bounds was not checked correctly."
				);
	}

	@Test
	void testCaesarDecryption() {
		assertEquals(
				"LET'S MEET TOMORROW AT 5:00 AM",
				CryptoManager.caesarDecryption(CryptoManager.caesarEncryption("LET'S MEET TOMORROW AT 5:00 AM", 12), 12),
				"Test failed because original strings are not matching."
				);
		assertNotEquals(
				"LET'S MEET TOMORROW AT 5:00 AM",
				CryptoManager.caesarDecryption(CryptoManager.caesarEncryption("LET'S MEET TOMORROW AT 12:00 PM", 12), 12),
				"Test failed because strings are matching."
				);
	}

}
