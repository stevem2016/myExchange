package edu.acc.java;

import java.io.IOException;

public class PopAstack {

	public static void main(String[] args) {
		PopAstack poppa = new PopAstack();
       	int y = 2;
        poppa.x();
        if (false) {}
        else if (y == 2) {
        	System.out.println("hey");

        boolean me = true;
        while (me) {
          	me = false;
        }
        meme:
        do {
        	System.out.println(y);
        	if (y == 7) {
        		continue meme;
        		
        	}
        	y++;
        } while (y < 10);
        
        for (int i=0; i < 5; i++) {
        	System.out.print(i);
        }
        
        boolean[] my_bools = {true, false, false};
        for (boolean b : my_bools) {
        	System.out.println(b);
        	
        }
        
        String h = "wow";
        switch (h) {
        default: 
        case "noon": System.out.println(h); 
                     break;
        case "night": System.out.println(h);
        case "day": System.out.println("zap");
        }
        
        }
        System.out.println(y);
	}
	
	void x() {
		int i = 8;
		y(i);
	}
	
	void y(int some_var) {
		String g = "hi";
		z(g);
	}
	
	void z(String my_s) {
		//try {
		System.out.println("We made it to z()" + 3/0);  // cause error
		//}
		//catch (Exception ex) {
	        //	System.out.println("hey, caught that div by zero: " + ex);
		//}
	}

}
