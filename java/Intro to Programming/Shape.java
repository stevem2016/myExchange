package edu.acc.java;

/**
 * Reads shape and dimension arguments from the command line then acts upon them.
 * 1st arg is shape type which is followed by one or more dimensions required to compute area
 * e.g. square 5
 *      triangle 6 2
 *      circle 3
 *      
 * @author pi
 *
 */
public class Shape {

	public Shape() {
		System.out.println("this is the Shape constructor");
	}
	
	public static void main(String[] args) {
		// stop gracefully if no args given
		if (args.length == 0) {
			System.out.println("No args detected....");
			System.out.println("Enter shape followed by dimensions....");
			return;
		}
		
		// we have at least one arg so check its shape type and print area else err msg
		Shape shape = new Shape();
		
		switch (args[0]) {
		case "circle": if (args.length > 1) {
			              double area = shape.getCircleArea(args[1]);
			              System.out.println("Circle of radius " + args[1] + " is " + area);
	                      }
		               else {
		                  System.out.println("Circle needs a radius");
		                  return;
		                  }
		               break;
		case "triangle": shape.getTriangleArea();
                               // left as exercise
		               break;
		case "square": shape.getSquareArea();
                               // left as exercise
		               break;
		default: System.out.println("Invalid shape entered");
		}
        
	}
	
	public double getCircleArea(String radius) {
		 double area = 0.0;
		 
		try {
		  // convert radius from String to double	
		  double r = Double.parseDouble(radius);
		  area = Math.PI * r * r;
		}
		catch (Exception ex) {
			System.out.println("Sorry, bad radius");
			System.exit(127);
		}
		return area;
	}

	public double getTriangleArea() {
		// TODO
		return 0.0;
	}

	public double getSquareArea() {
		// TODO
		return 0.0;
	}

}
