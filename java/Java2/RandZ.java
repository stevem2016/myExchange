package edu.acc.java;
import java.util.Random;

public enum RandZ {Z1, Z2, Z3, Z4, Z5;
/*
 * RandZ is an enum with five symbols, each symbol is a random integer
 */
	
    private int z_value;
    
	{
		Random generator = new Random(); 
        this.z_value = generator.nextInt(255);  // range is 0 - 254
	}

	public static void main(String[] args) {
		RandZ[] z_array = {Z1, Z2, Z3, Z4, Z5};
		for (RandZ val : z_array) 
		    System.out.println("Z value: " + val.z_value);
	}
}
