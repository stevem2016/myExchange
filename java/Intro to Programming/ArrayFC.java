package edu.acc.java;

/**
 * Converts Fahrenheit temps in an array to Centigrade temps in another array.
 * Also provides practice in using instances.
 * 
 * 1) Create a new class called ArrayFC with (2) array variables:
 *    - a float array called f_temps with at least (3) temperatures
 *    - a double array with the same number of elements as f_temps
 * 2) Create an instance method called f2c that returns a double Centigrade temp and 
 *    receives a float parameter for input Fahrenheit temp.
 * 3) In the main() method create an instance of ArrayFC, then iterate over the 
 *    f_temps array inserting a Centigrade temp in the c_temps array for each f_temp.
 *    Also print the values in both arrays as: "The value of <f_temp> is <c_temp>"
 *    Use 3 decimal places for the C temp.
 * 
 * @author pi
 *
 */

public class ArrayFC {

	float[] f_temps = {100.12f, 200.99f,300.33f, 4.55f};  // allocate and initialize
	double[] c_temps = new double[f_temps.length];  // just allocate


	public static void main(String[] args) {
		ArrayFC my_lab = new ArrayFC();

		for (int i=0; i < my_lab.f_temps.length; i++) {
		my_lab.c_temps[i] = my_lab.f2c(my_lab.f_temps[i]);
		System.out.printf("The value of %.2fF is %.3fC\n",
				my_lab.f_temps[i] ,my_lab.c_temps[i]);
		}

	}

	double f2c(float f_temp) {
		return (f_temp - 32) * (5./9.);		
	}
}
