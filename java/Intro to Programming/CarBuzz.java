package edu.acc.java;

/**
 *  From i = 1 to 30
 *    if i is multiple of 3 print i and  "car"
 *    if i is multiple of 5 print  i and "buzz"
 *    if i is multiple or 3 and 5 print  i and "carbuzz"
 *    if none of the above print i only
 *    
 * @author pi
 *
 */

public class CarBuzz {

	public static void main(String[] args) {
		for (int n=1; n <= 30; n++) {

			String result = "";
			if (n%3 == 0) {
				result += "car";
			}
			if (n%5 == 0) {
				result += "buzz";
			}
		    System.out.println(n + " " + result);	
		}

	}

}
