package edu.acc.java;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Word frequencies
 * 
 * 1) Write a class WordFreq that tracks word frequencies in a String. What type would be appropriate?
 *    Ignore punctuation and whitespace. Words are separated by one or more spaces.
 *    
 * 2) Test WordFreq with a random selection of text from the Java API of at least 100 words
 * 
 * 3) Is there a Map implementation that sorts the keys? Demonstrate
 * 
 * @author pi
 *
 */

public class WordFreq {

	String word_source = "A collection that contains no duplicate elements. More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2), and at most one null element. As implied by its name, this interface models the mathematical set abstraction."
			+ " The Set interface places additional stipulations, beyond those inherited from the Collection interface, on the contracts of all constructors and on the contracts of the add, equals and hashCode methods. Declarations for other inherited methods are also included here for convenience. (The specifications accompanying these declarations have been tailored to the Set interface, but they do not contain any additional stipulations.)"
			+ " The additional stipulation on constructors is, not surprisingly, that all constructors must create a set that contains no duplicate elements (as defined above)."
			+ " Note: Great care must be exercised if mutable objects are used as set elements. The behavior of a set is not specified if the value of an object is changed in a manner that affects equals comparisons while the object is an element in the set. A special case of this prohibition is that it is not permissible for a set to contain itself as an element."
			+ " Some set implementations have restrictions on the elements that they may contain. For example, some implementations prohibit null elements, and some have restrictions on the types of their elements. Attempting to add an ineligible element throws an unchecked exception, typically NullPointerException or ClassCastException. Attempting to query the presence of an ineligible element may throw an exception, or it may simply return false; some implementations will exhibit the former behavior and some will exhibit the latter. More generally, attempting an operation on an ineligible element whose completion would not result in the insertion of an ineligible element into the set may throw an exception or it may succeed, at the option of the implementation. Such exceptions are marked as  in the specification for this interface."
			+ " This interface is a member of the Java Collections Framework.";

	/**
	 * Computes word frequencies
	 * 
	 * @param words is word source as a String
	 * @return Map where word is the key, frequency is the count of occurrences of the key in words
	 */
	public Map<String, Integer> getWordFrequency(String words) {
		String[] split_words = words.split(" ");
		Map<String, Integer> freq_map = new TreeMap<>();
		for (String w : split_words) {
			w = build_key(w);  // build a key from the split off word
			if (w.isEmpty()) continue;  // skip empty keys
			if (freq_map.containsKey(w)) { // if key already seen
				int value = freq_map.get(w);
				freq_map.put(w, ++value);  // bump count
			} else {
				// new word so add to Map
				freq_map.put(w, 1);
			}
		}
		return freq_map;
	}

	/**
	 * Builds a key from given word by removing non-alpha characters
	 * 
	 * @param w is the raw word input
	 * @return a key i.e. sequence of one or more lower case alpha characters
	 */
	String build_key(String w) {
		StringBuilder key = new StringBuilder();
		
		for (char c : w.toCharArray()) {
			// if alpha char add it to key
			if (Character.isAlphabetic(c)) {
				key.append(Character.toLowerCase(c));
			}
		}
		return key.toString();
	}

	public static void main(String[] args) {
		WordFreq wf = new WordFreq();
		System.out.println(wf.getWordFrequency(wf.word_source));
	}

}
