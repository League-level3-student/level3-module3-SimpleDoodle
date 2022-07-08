package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		if (s1.length() < s2.length()) {
			return s2;
		} else {
			return "equal";
		}
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		String replaced = s;
		if (s.contains("underscores")) {
			replaced = s.replace(' ', '_');
		}
		return replaced;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char last1 = s1.trim().charAt(s1.trim().indexOf(' ') + 1);
		char last2 = s2.trim().charAt(s2.trim().indexOf(' ') + 1);
		char last3 = s3.trim().charAt(s3.trim().indexOf(' ') + 1);
		if (last1 < last2) {
			if (last1 < last3) {
				return s1.trim();
			}
		}
		if (last2 < last1) {
			if (last2 < last3) {
				return s2.trim();
			}
		}
		if (last3 < last2) {
			if (last3 < last1) {
				return s3.trim();
			}
		}
		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
		if (Character.isDigit(s.charAt(i)) == true) {
			if (Integer.parseInt(s.substring(i, i + 1)) == 1 || Integer.parseInt(s.substring(i, i + 1)) == 2
					|| Integer.parseInt(s.substring(i, i + 1)) == 3 || Integer.parseInt(s.substring(i, i + 1)) == 4
					|| Integer.parseInt(s.substring(i, i + 1)) == 5 || Integer.parseInt(s.substring(i, i + 1)) == 6
					|| Integer.parseInt(s.substring(i, i + 1)) == 7 || Integer.parseInt(s.substring(i, i + 1)) == 8
					|| Integer.parseInt(s.substring(i, i + 1)) == 9) {
				sum += Integer.parseInt(s.substring(i, i+1));
			}
		}	
		}
		return sum;

	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int numOccur = 0;
	      int index = s.indexOf(substring);
	        while( index != -1 ) {
	            numOccur++;
	            index = s.indexOf(substring, index + substring.length());
	        }
			return numOccur;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte b = (byte)key;
		String encryption = Utilities.encrypt(s.getBytes(), b);
		return encryption;
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		byte b = (byte)key;
		String decryption = Utilities.decrypt(s, b);
		return decryption;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int counter = 0;
		int index = s.indexOf(substring);
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < s.length()-1; j++) {
		//			if (s.substring(index + substring.length()) == " ") {
		//				
		//			}
		//		}
		//	}
			 if (s.substring(index + substring.length(), index + substring.length()+1).equals(" ")) {
				counter++;
			}
				return counter;
		 }

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
