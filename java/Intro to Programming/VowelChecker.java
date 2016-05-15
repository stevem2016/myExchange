package edu.acc.java;

/**
 * Sentence vowel checker.
 * In a given word find all occurances of vowels and 
 * print the count in addition to word. Use "aardvarkien".
 * 
 * 
 * @author pi
 *
 */

public class VowelChecker {

	public static void main(String[] args) {

		String sentence = "I am an aardvarkien from Mercury";
		int vowelCount = 0;

		for (int i=0; i < sentence.length(); i++) {
			String nextChar = sentence.substring(i,i+1);
			if (isVowel(nextChar)) {
				vowelCount++;
				System.out.print(nextChar + " ");
			}
		}
		System.out.println();
		System.out.println("Vowel count: " + vowelCount);
	}
	
	/**
	 * Vowel count method
	 * @param c is char to check
	 * @return true if a vowel, else false
	 */
	static boolean isVowel(String c) {
		switch (c.toLowerCase()) {
		case "a":
		case "e":
		case "i":
		case "o":
		case "u": return true;
		}
		return false;
	}

}
