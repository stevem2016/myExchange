package edu.acc.java;

/**
 * Reads a Centigrade (C) or Fahrenheit (F) temperature from command line and returns the other scale temp
 * In Eclipse, command line arguments are entered on Run/Run Configurations/Arguments tab
 * 
 * @author pi
 *
 */
public class ArgsFC {

	public static void main(String[] args) {
		// make sure something was given in args
		if (args.length == 0) {  
			System.out.println("no args found");
			return;
		}
		// get temp into a variable for ease of understanding
		String origTemp = args[0]; // note this is a String 
		// what is the temp type character which is the last character?
		String tempType = origTemp.substring(origTemp.length() - 1);
		System.out.println("temp type is " + tempType);
		// what is the temp value? start from beginning of string and stop before last character
		String tempValue = origTemp.substring(0, origTemp.length() -1);
		System.out.println("temp value is " + tempValue);
		// convert to int value for doing arithmetic
		int temp = Integer.parseInt(tempValue);
		// now convert to the other scale
		double convertedTemp = 0;
		String convertedType = null;
		if (tempType.toLowerCase().equals("c")) { // lower case so we only have one comparison
			// found a C temp so convert to F temp
			convertedTemp = c2f(temp);
			convertedType = "F";
		}
		else {
			convertedTemp = f2c(temp);
			convertedType = "C";
		}
   		System.out.println(origTemp + " is " + convertedTemp + convertedType);
	}

	static double c2f(int ftemp) {
		// TODO implement 
		return 0;
	}

	static double f2c(int ctemp) {
		// TODO implement 
		return 0;
	}
	

}
