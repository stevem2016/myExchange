package edu.acc.java;

import java.util.Random;

public class TempConverter {

	private int f_temp = 212;  // declare only

	public int getF_temp() {
		return f_temp;
	}

	public void setF_temp(int f_temp) {
		this.f_temp = f_temp;
	}

	static int x_temp = 9;
	
	/**
	 * 
	 * @param actual_temp
	 */
	public TempConverter(int actual_temp, String name) {
		if (actual_temp > 0) {
			f_temp = actual_temp;
		}
		else {
			f_temp = 88;
		}
//		f_temp = actual_temp;
		for (int i = 0; i < 4; i++) {
		    System.out.println("in MyOtherClass constructor: i = " + i);
		    switch (i) {
		    case 1: System.out.println(name); 
		            break;
		    case 2: System.out.println("was a 2");
		    case 3: System.out.println("was a pink unicorn");
		    default: System.out.println("Something is very wrong");
		    }
		    }
	}
	
	public TempConverter() {} // "no arg" constructor

	/**
	 * This is our main method...
	 * 
	 * @param args
	 */
	public static void main(String[] x) {
        /* this is another kind of comment 
         * block comment 
         * 
         * */
		String myString = "me";
		
		TempConverter me1 = new TempConverter(1, "jo");
		TempConverter me2 = new TempConverter(0, "mo");
		TempConverter me3 = new TempConverter(-1, "harry"); 

		System.out.println("me1.f_temp "
				+ "is " + 
		                    me1.f_temp  );
		System.out.println("me2.f_temp is " + me2.f_temp  );
		System.out.println("me3.f_temp is " + me3.f_temp  );
		System.out.println("me3.x_temp is " + me3.x_temp  );

	}
}
