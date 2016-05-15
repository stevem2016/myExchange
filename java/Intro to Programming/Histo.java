package edu.acc.java;
/*  I changed this - blame me!
 * So did I!
 * Histograms with user selected labels and star counts.
 * 
 * Lab Description: write a class named Histo that includes a
 *  static method with following signature: 
 *      void histogram(String[] labels, int[] stars)
 *  which allows a label and number of stars for each horizontal line.
 *  Validate inputs and give useful error messages. Start the stars
 *  at the same column without using printf() formatting.
 *
 * Example output:
 *    trees      *******
 *    butterflys ****************
 *    clouds     **
 *    
 * Use at least (3) labels of different lengths.
 *
 * Also try some of the code puzzles at http://codingbat.com/java in Logic-1
 *
 * Hint: here is some p-code (pseudo code):
 *       // error checks: are input arrays null? 
 *       //               are they the same length?
 *       //               is there at least one label?
 *       // find the longest label: loop over the labels and use length() method,
 *       //               keeping track of the longest
 *       // print the histogram: in a loop, print the label, then the padding
 *       //               spaces, then the required number of stars
 */

public class Histo {

	public static void main(String[] args) {

		// we could initialize the two arrays as usual:

                // String[] labels = new String[3];
                // labels[0] = "butterflys";
                // labels[1] = "octopii";
                // labels[2] = "this_is___a____very_____long______label";
                // int[] stars = new stars[3];
                // stars[0] = 5;
                // stars[1] = 8;
                // stars[2] = 22;

                // or this shortcut way...

		histogram(new String[]{"butterflys","octopii",
				  "this_is___a____very_____long______label"}, 
				  new int[]{5,8,22});  // assumes already normalized
	}
	
	private static void histogram(String[] labels, int[] stars) {
            // some basic sanity checks
		if (labels == null) {
			System.out.println("labels array is null");
			return;
		}
		if (stars == null) {
			System.out.println("stars array is null");
			return;
		}
		if (labels.length != stars.length) {
		    System.out.println("labels and stars must be same length");
		    return;
		}
        if (stars.length == 0) {
		    System.out.println("must have at least one label");
		    return;
                }
		
            // Ok, good to go. First find the longest label
        
            int maxLabelLength = 1;
            
            for (int i=0; i < labels.length; i++) {
        	    if (labels[i].length() > maxLabelLength) {
        	        maxLabelLength = labels[i].length();	
        	    }
            }
            
            maxLabelLength = Math.min(maxLabelLength,  20);  // set upper bound for label size
    
            // print the histogram        
            
            for (int i=0; i < labels.length; i++) {
        	    // first the label (truncated to 20 characters if necessary), and stay on same line
            	if (labels[i].length() > maxLabelLength) {
            		System.out.print(labels[i].substring(0, 20) + " ");
            	}
            	else {
            		System.out.print(labels[i] + " ");
            	}
    
        	    // add padding spaces if needed
        	    int paddingSpaces = maxLabelLength - labels[i].length();
        	    for (int j=0; j < paddingSpaces; j++) {
        		    System.out.print(" ");
        	    }
    
        	    // print the stars
        	    for (int j=0; j < stars[i]; j++) {
        		    System.out.print("*");
        	    }
            	
        	    // new line
        	    System.out.println();
            }
	}

}
