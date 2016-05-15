package edu.acc.java;

/**
 * Formats a table of output data per lab requirements
 * 
 * @author pi
 *
 */
public class FormattedTable {

	public static void main(String[] args) {
		System.out.printf("%12s %-12s %-12s %n","Hits","Rates","Percentages");
		System.out.printf("%12d %-12.1f %-12.2f %n",0,555.23f,555.23f/100);
		System.out.printf("%12d %-12.1f %-12.2f %n",1,555.23f,555.23f/100);
		System.out.printf("%12d %-12.1f %-12.2f %n",2,555.23f,555.23f/100);
		System.out.printf("%12d %-12.1f %-12.2f %n",3,555.23f,555.23f/100);
		System.out.printf("%12d %-12.1f %-12.2f %n",4,555.23f,555.23f/100);
		System.out.printf("%12d %-12.1f %-12.2f %n",5,555.23f,555.23f/100);
		System.out.printf("%12d %-12.1f %-12.2f %n",6,555.23f,555.23f/100);

		// misc experiments
        String[] x = new String[]{"a","b","c"};
		System.out.println(x.length + " " + x[1].length());
		System.out.println(Integer.parseUnsignedInt("15", 16));
		System.out.println(Integer.valueOf(1).equals(Long.valueOf(1)));

	}

}
