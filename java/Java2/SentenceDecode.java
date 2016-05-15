package edu.acc.java;

public class SentenceDecode {

	public static void main(String[] args) {

		// initialize a sentence String variable
		String sentence = "Hey Newton, do I see 9 Apples on your head?";
		//char[] charSentence = sentence.toCharArray(); // could do this too
		// in a loop:
		for (int i=0; i < sentence.length(); i++) {
		//    get next char
			char next = sentence.charAt(i);
		//    if a letter:
		//        if upper case print "upper letter"
		//        else print "lower letter" and continue
			if (Character.isLetter(next)) {
				if (Character.isUpperCase(next))
					System.out.println("upper letter");
				else 
					System.out.println("lower letter");
			}
		//    if whiteSpace:
		//        print "white space" and continue
			else if (Character.isWhitespace(next)) {
					System.out.println("white space ");
			}
		//    if a digit:
		//        print "digit" and  continue
			else if (Character.isDigit(next)) {
					System.out.println("digit ");
			}
			else {
				System.out.println("probably punctuation ...skipping");
			}
		}
	}

}
