package edu.acc.java;

/**
 * Demonstrate passing object references and primitives
 * 
 * @author pi
 *
 */
public class PassingArguments {

	String[] old_stuff = {"aa", "bb", "cc"};
	int old_x = 8;
	
	public String showMe(int x, String... stuff) {
		String result = "";  // an empty String to concatenate to

		/* what happens if you comment out following line? */
		stuff = new String[3];  

		stuff[0] = "uu";
		stuff[1] = "vv";
		stuff[2] = "ww";
		
		for (String next : stuff) {
			result += next;
		}
		
		/* now let's increment old_x */
		x++;
		
		return result;
	}

	public static void main(String[] args) {
	    PassingArguments ref = new PassingArguments();
		String u = ref.showMe(ref.old_x, ref.old_stuff);
		for (String next : ref.old_stuff) {
			System.out.println(next);
		}
		System.out.println(u);
		System.out.println(ref.old_x);

	}

}
