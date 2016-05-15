package edu.acc.java;

public class Square extends Shape {
	
	private int sideLength;
	
	public Square() {
		super("hi");
		System.out.println("Square() constructor");
	}
	
	public Square(String b) {
		this();
		System.out.println("Square(String) constructor");
	}
	

	public static void main(String[] args) {
        Square sq = new Square("Steve question");
	}

	public int getSideLength() {
		return this.sideLength;
	}
	
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
}
