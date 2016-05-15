package edu.acc.java;

/** Rectangle class

- Create a Rectangle class with instance variables (attributes,
  state) for the length and width, both floating point numbers.

- The class should have at least two constructors. The default
  constructor, Rectangle(), should initialize the instance
  variables to 1.0.

- The class should have setters and getters; the
  setters must ensure that the parameters are between 1.0 and 50.0.

- The class should have methods that return the perimeter
  and the area of the shape.

- Create an main() that instantiates at least as many objects
  as constructors in Rectangle i.e. uses all the constructors,
  and exercises all methods of Rectangle.

 * @author pi
 *
 */

public class Rectangle {

	private float length;
	private float width;
	
	/**
	 * Constructor #1
	 */
	public Rectangle() {
		this.length = 1.0f;
		this.width = 1.0f;
	}
	
	/**
	 * Constructor #2
	 */
	public Rectangle(float new_length, float new_width) {
		this();  // default sides to 1.0f
		if (dimensions_ok(new_length)) {
		    this.length = new_length;
		}
		if (dimensions_ok(new_width)) {
		    this.width = new_width;
		}
	}
		
	/**
	 * Constructor #3
	 */
	public Rectangle(float side) {
	    this(side, side);
	}
	
	public float getLength() {
		return this.length;
	}
	
	public void setLength(float new_length) {
		if (dimensions_ok(new_length)) {
		    this.length = new_length;
		}
	}

	public float getWidth() {
		return this.width;
	}
	
	public void setWidth(float new_width) {
		if (dimensions_ok(new_width)) {
		    this.width = new_width;
		}
	}

	private boolean dimensions_ok(float test_dimension) {
		if (test_dimension >= 1.0f && test_dimension <= 50.0f) {
			return true;
		}
		return false;
	}
	
	private float area() {
		return this.length * this.width;
	}
	
	private float perimeter() {
		return this.length * 2 + this.width * 2;
	}
	
	private void printSides() {
		System.out.println("Length: " + this.length + " Width: " + this.width);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();  // default constructor
		System.out.println("No arg constructor makes [1,1] Rectangle");
		rect.printSides();
		System.out.println("[Area] " + rect.area());
		System.out.println("[Perimeter] " + rect.perimeter());
		System.out.println();

		rect = new Rectangle(2, 3);  // length and width constructor
		System.out.println("Length, width constructor makes [2,3] Rectangle");
		rect.printSides();
		System.out.println("Using getters, Length: " + rect.getLength() 
				                      + " Width: " + rect.getWidth());
		rect.setLength(4f);
		rect.setWidth(5f);
		System.out.println("Setters change to [4,5] Rectangle");
		rect.printSides();
		System.out.println("[Area] " + rect.area());
		System.out.println("[Perimeter] " + rect.perimeter());
		System.out.println();

		System.out.println("Single side constructor makes [3,3] Rectangle");
		rect = new Rectangle(3);  // one side constructor
		rect.printSides();
		System.out.println("[Area] " + rect.area());
		System.out.println("[Perimeter] " + rect.perimeter());

	    // try some errors...

		rect = new Rectangle(0, -3);
		System.out.println("[0,-3] Rectangle should be converted to [1,1]");
		rect.printSides();
		rect.setLength(-4f);
		rect.setWidth(-5f);
		System.out.println("[Setters try to change sides to -4,-5]");
		rect.printSides();
		System.out.println();

	}

}
