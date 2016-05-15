package edu.acc.java;

/**
 * Exercises 2 and 3 on p.308 of text
 * Does not fold case
 * Letters only
 * 
 * @author pi
 *
 */
public class InitialsAnagram {

	public static void main(String[] args) {
        new InitialsAnagram().get_initials("Bob The Builder");
        new InitialsAnagram().anagram_detect("parliament", "partial men");
        new InitialsAnagram().anagram_detect("software", "swear oft");
	}
	
	/**
	 * Detects if s1 is anagram of s2 and prints verdict
	 * 
	 * @param s1 is String to compare
	 * @param s2 is String to compare
	 */
	void anagram_detect(String s1, String s2) {
		// make a mutable copy of s1
	    StringBuilder sb_s1 = new StringBuilder(s1);
	    System.out.println();
	    // loop over each character in s2 and remove from s1
	    for (char c : s2.toCharArray()) {
	    	// ignore whitespace
	    	if (!Character.isLetter(c))
	    		continue;
	    	int index = sb_s1.indexOf(String.valueOf(c));
	    	System.out.println(c + " " + index);
	    	// did we find this character in other String?
	    	if (index < 0) {
	    		// no
	    		System.out.println("not an anagram");
	    		return;
	    	}
	    	    // yes, so delete it and continue
	    	sb_s1.deleteCharAt(index);
	    }
	    // make sure no letters left in other String
	    if (sb_s1.toString().trim().isEmpty())
   		    System.out.println("anagram confirmed");
	    else
   		    System.out.println("not an anagram");
	    	
	}
	/**
	 * Prints the initial character of each word in full_name
	 * @param full_name is the name to convert to initials
	 */
	void get_initials(String full_name) {
		// split the name into parts
		String[] split_name = full_name.split(" ");
		System.out.print("Initials are ");
		for (String name_part : split_name) {
			// print first character of each word
			System.out.print(name_part.charAt(0));
		}
		System.out.println();
	}

}
