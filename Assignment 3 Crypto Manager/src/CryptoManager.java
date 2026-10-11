import java.util.ArrayList;

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


/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students
    	
    	// Check if String is in bounds, else return error message
    	if(!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds. Try again.";
    	}else {
    		String encryptedMessage = "";
    		int j = 0;
    		for(int i = 0; i < plainText.length(); i++) {
    			char plainChar = plainText.charAt(i);
    			char keyChar = key.charAt(j);
    			int encryptedChar = (ALPHABET64.indexOf(plainChar) + ALPHABET64.indexOf(keyChar)) % 64;
    			char newChar = ALPHABET64.charAt(encryptedChar);
    			encryptedMessage = encryptedMessage + newChar;
    			j++;
    			if(j == key.length()) {
    				j = 0;
    			}
    		}
    		return encryptedMessage;
    	}
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         //to be implemented by students
    		String decryptedMessage = "";
    		int j = 0;
    		for(int i = 0; i < encryptedText.length(); i++) {
    			char encrypChar = encryptedText.charAt(i);
    			char keyChar = key.charAt(j);
    			// Add 64 to prevent negative index
    			int encryptedChar = (ALPHABET64.indexOf(encrypChar) - ALPHABET64.indexOf(keyChar) + 64) % 64;
    			char newChar = ALPHABET64.charAt(encryptedChar);
    			decryptedMessage = decryptedMessage + newChar;
    			j++;
    			if(j == key.length()) {
    				j = 0;
    			}
    		}
    		return decryptedMessage;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
         //to be implemented by students
    	
    	// Check if String is in bounds, else return error message
    	if(!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds. Try again.";
    	}else {
    		String text = key;
    		ArrayList<Character> textArray = new ArrayList<Character>();
    		
    		// Add the String into a Character Array
    		for(int i = 0; i < text.length(); i++) {
    			textArray.add(text.charAt(i));
    		}
    		
    		System.out.println(textArray.toString());
    		
    		// Remove the Duplicate Elements and Store duplicate characters in a String
    		String duplicateCharacters = "";
    		for(int i = 0; i < textArray.size()-1; i++) {
    			for(int j = i+1; j < textArray.size(); j++) {
    				int duplicateCount = 0;
    				if(textArray.get(i) == textArray.get(j)) {
    					textArray.remove(j);
    					if(duplicateCount == 0) {
    						duplicateCharacters += textArray.get(i);
    						duplicateCount++;
    					}
    				}
    				duplicateCount = 0;
    			}
    		}
    		
    		System.out.println("Duplicated Characters: " + duplicateCharacters);
    		System.out.println(textArray);
    		
    		
    		// Create the 8x8 Matrix to perform the Encryption
    		char[][] matrix = new char[8][8];
    		
    		// Layout the Keyword Over the Matrix and the remaining 64 characters
    		// Make sure to insert a duplicate character only once - uses for-loop to validate
    		// That means, insert the full updated Text Array
    		
    		// Insert the Keyword (without duplicates)
    		int count = 0;
    		int alphabetCount = 0;
    		for(int i = 0; i < matrix.length; i++) {
    			for(int j = 0; j < matrix[i].length; j++) {
    				// Add the Keyword First, then add the remaining 64 characters
    				if(count < textArray.size()) {
    					matrix[i][j] = textArray.get(count);
    					count++;
    				}else {
    					// Insert only the characters not matching the keyword (those were already inserted)
    					boolean matching = false;
    					for(int w = 0; w < textArray.size(); w++) {
    						if(ALPHABET64.charAt(alphabetCount) == textArray.get(w)) {
    							matching = true;
    							break;
    						}
    					}
    					if(!matching) {
    						matrix[i][j] = ALPHABET64.charAt(alphabetCount);	
    					}else {
    						j--;
    					}
    					alphabetCount++;
    					
    				}
    			}
    		}
    		
    		
    		// Display the matrix array
    		for(char[] firstArray: matrix) {
    			for(char c: firstArray) {
    				System.out.print(c + ", ");
    			}
    			System.out.println();
    		}
    		
    		// Break the PlainText Into Pairs
    		// Store said pairs in an ArrayList
    		// Add an X to the last element for odd length Strings
    		String message = plainText;
    		int rows = (message.length() + 1) / 2;
    		char[][] encryptedPairsOfMessage = new char[rows][2];
    		char[][] pairsOfMessage = new char[rows][2];

    		int plainCount = 0;

    		for (int i = 0; i < rows; i++) {
    		    for (int j = 0; j < 2; j++) {
    		        if (plainCount < message.length()) {
    		            pairsOfMessage[i][j] = message.charAt(plainCount);
    		            plainCount++;
    		        } else {
    		            pairsOfMessage[i][j] = 'X';
    		        }
    		    }
    		}
    		
    		// Display the Pair Array
    		for(char[] firstArray: pairsOfMessage) {
    			for(char c: firstArray) {
    				System.out.print(c + ", ");
    			}
    			System.out.println();
    		}
    		
    		// Store the column and row for each pair and perform the following - 
    		// If Same row - move to the right
    		// If Same column - move down
    		// If all different - switch columns
    		for(int row = 0; row < pairsOfMessage.length; row++) {
    			char firstChar = pairsOfMessage[row][0];
    			char secondChar = pairsOfMessage[row][1];
    			int firstCharRow = 0;
    			int firstCharCol = 0;
    			int secondCharRow = 0;
    			int secondCharCol = 0;
    			
    			// Loop through the matrix and store the 4 variables above
    			for(int i = 0; i < matrix.length; i++) {
    				for(int j = 0; j < matrix[i].length; j++) {
    					if(firstChar == matrix[i][j]) {
    						firstCharRow = i;
    						firstCharCol = j;
    					}
    					if(secondChar == matrix[i][j]) {
    						secondCharRow = i;
    						secondCharCol = j;
    					}
    				}
    			}
    			
    			System.out.println(firstCharRow + " " + firstCharCol);
    			System.out.println(secondCharRow + " " + secondCharCol);
    			
    			// If the rows are same, move right
    			// If the columns are same, move down
    			// If all different, swap columns
    			// Wrap around if need be
    			if(firstCharRow == secondCharRow) {
    				encryptedPairsOfMessage[row][0] = matrix[firstCharRow][(firstCharCol+1) % 8];
    				encryptedPairsOfMessage[row][1] = matrix[secondCharRow][(secondCharCol+1) % 8];
    			}else if(firstCharCol == secondCharCol) {
    				encryptedPairsOfMessage[row][0] = matrix[(firstCharRow+1) % 8][firstCharCol];
    				encryptedPairsOfMessage[row][1] = matrix[(secondCharRow+1) % 8][secondCharCol];
    			}else {
    				encryptedPairsOfMessage[row][0] = matrix[firstCharRow][secondCharCol];
    				encryptedPairsOfMessage[row][1] = matrix[secondCharRow][firstCharCol];
    			}    			    			   			
    			
    		}
    		
    		System.out.println();
    		// Display the encrypted array
    		String finalEncryptedMessage = "";
    		for(char[] firstArray: encryptedPairsOfMessage) {
    			for(char c: firstArray) {
    				System.out.print(c + ", ");
    				finalEncryptedMessage += c;
    			}
    			System.out.println();
    		}
    		
    		System.out.println(finalEncryptedMessage);
    		
    		return finalEncryptedMessage;
    		
    	}
    	
    	
    }

    // Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
         //to be implemented by students
    	String text = key;
		ArrayList<Character> textArray = new ArrayList<Character>();
		
		// Add the String into a Character Array
		for(int i = 0; i < text.length(); i++) {
			textArray.add(text.charAt(i));
		}
		
		System.out.println(textArray.toString());
		
		// Remove the Duplicate Elements and Store duplicate characters in a String
		String duplicateCharacters = "";
		for(int i = 0; i < textArray.size()-1; i++) {
			for(int j = i+1; j < textArray.size(); j++) {
				int duplicateCount = 0;
				if(textArray.get(i) == textArray.get(j)) {
					textArray.remove(j);
					if(duplicateCount == 0) {
						duplicateCharacters += textArray.get(i);
						duplicateCount++;
					}
				}
				duplicateCount = 0;
			}
		}
		
		System.out.println("Duplicated Characters: " + duplicateCharacters);
		System.out.println(textArray);
		
		
		// Create the 8x8 Matrix to perform the Encryption
		char[][] matrix = new char[8][8];
		
		// Layout the Keyword Over the Matrix and the remaining 64 characters
		// Make sure to insert a duplicate character only once - uses for-loop to validate
		// That means, insert the full updated Text Array
		
		// Insert the Keyword (without duplicates)
		int count = 0;
		int alphabetCount = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				// Add the Keyword First, then add the remaining 64 characters
				if(count < textArray.size()) {
					matrix[i][j] = textArray.get(count);
					count++;
				}else {
					// Insert only the characters not matching the keyword (those were already inserted)
					boolean matching = false;
					for(int w = 0; w < textArray.size(); w++) {
						if(ALPHABET64.charAt(alphabetCount) == textArray.get(w)) {
							matching = true;
							break;
						}
					}
					if(!matching) {
						matrix[i][j] = ALPHABET64.charAt(alphabetCount);	
					}else {
						j--;
					}
					alphabetCount++;
					
				}
			}
		}
		
		
		// Display the matrix array
		for(char[] firstArray: matrix) {
			for(char c: firstArray) {
				System.out.print(c + ", ");
			}
			System.out.println();
		}
		
		// Break the PlainText Into Pairs
		// Store said pairs in an ArrayList and ignore spaces
		String message = encryptedText;
		int rows = (message.length() + 1) / 2;
		char[][] encryptedPairsOfMessage = new char[rows][2];
		char[][] pairsOfMessage = new char[rows][2];

		int plainCount = 0;

		for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < 2; j++) {
		        if (plainCount < message.length()) {
		            pairsOfMessage[i][j] = message.charAt(plainCount);
		            plainCount++;
		        } else {
		            pairsOfMessage[i][j] = 'X';
		        }
		    }
		}
		
		// Display the Pair Array
		for(char[] firstArray: pairsOfMessage) {
			for(char c: firstArray) {
				System.out.print(c + ", ");
			}
			System.out.println();
		}
		
		//Store the column and row for each pair and perform the following - 
		// If Same row - move to the right
		// If Same column - move down
		// If all different - switch columns
		for(int row = 0; row < pairsOfMessage.length; row++) {
			char firstChar = pairsOfMessage[row][0];
			char secondChar = pairsOfMessage[row][1];
			int firstCharRow = 0;
			int firstCharCol = 0;
			int secondCharRow = 0;
			int secondCharCol = 0;
			
			// Loop through the matrix and store the 4 variables above
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					if(firstChar == matrix[i][j]) {
						firstCharRow = i;
						firstCharCol = j;
					}
					if(secondChar == matrix[i][j]) {
						secondCharRow = i;
						secondCharCol = j;
					}
				}
			}
			
			System.out.println(firstCharRow + " " + firstCharCol);
			System.out.println(secondCharRow + " " + secondCharCol);
			
			// If the rows are same, move right
			// If the columns are same, move down
			// If all different, swap columns
			// Wrap around if need be
			// Add an 8 to prevent negative index
			if(firstCharRow == secondCharRow) {
				encryptedPairsOfMessage[row][0] = matrix[firstCharRow][(firstCharCol-1+8) % 8];
				encryptedPairsOfMessage[row][1] = matrix[secondCharRow][(secondCharCol-1+8) % 8];
			}else if(firstCharCol == secondCharCol) {
				encryptedPairsOfMessage[row][0] = matrix[(firstCharRow-1+8) % 8][firstCharCol];
				encryptedPairsOfMessage[row][1] = matrix[(secondCharRow-1+8) % 8][secondCharCol];
			}else {
				encryptedPairsOfMessage[row][0] = matrix[firstCharRow][secondCharCol];
				encryptedPairsOfMessage[row][1] = matrix[secondCharRow][firstCharCol];
			}
									
			
		}
		
		System.out.println();
		// Display the encrypted array
		String finalEncryptedMessage = "";
		for(char[] firstArray: encryptedPairsOfMessage) {
			for(char c: firstArray) {
				System.out.print(c + ", ");
				finalEncryptedMessage += c;
			}
			System.out.println();
		}
		
		System.out.println(finalEncryptedMessage);
		
		// Remove the X from the last index of the final message if present
		// This only applies to decrypted strings
		if(finalEncryptedMessage.charAt(finalEncryptedMessage.length()-1) == 'X') {
			finalEncryptedMessage = finalEncryptedMessage.substring(0, finalEncryptedMessage.length()-1);
		}
		
		return finalEncryptedMessage;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
	//to be implemented by students
    	
    	// Check if String is in bounds
    	// If so, encrypt the message
    	// Else, return an error message
    	// Also creates the updated ASCII array for wrapping around
    	String ASCII64 = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_";
    	
    	if(!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds. Try again.";
    	}else {
    		String encryptedMessage = "";
    		char encryptedChar;
    		for(int i = 0; i < plainText.length(); i++) {
    			for(int j = 0; j < ASCII64.length(); j++) {
    				if(plainText.charAt(i) == ASCII64.charAt(j)) {
    					encryptedChar = ASCII64.charAt((j + key) % 64);
    					encryptedMessage += encryptedChar;
    				}
    			}
    		}
    		
    		return encryptedMessage;
    	}
    	
    	
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	// to be implemented by students
    	// Creates the updated ASCII array for wrapping around
    	String ASCII64 = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_";
    	String decryptedMessage = "";
		char decryptedChar;
		for(int i = 0; i < encryptedText.length(); i++) {
			for(int j = 0; j < ASCII64.length(); j++) {
				if(encryptedText.charAt(i) == ASCII64.charAt(j)) {
					// Add 64 to prevent - index
					decryptedChar = ASCII64.charAt((j - key + 64) % 64);
					decryptedMessage += decryptedChar;
				}
			}
		}
		
		return decryptedMessage;
    }    

}
