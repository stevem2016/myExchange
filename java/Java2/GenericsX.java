package edu.acc.java;

import static java.lang.Math.*;

public class GenericsX<X> {
	
	X var;
	
	public GenericsX(X var) {
		this.var = var;
	}

	class Box<T extends Number> {
		private T side;

		public Box(T side) {
			this.side = side;
		}

		<I extends Number, D extends Number> double area(I length, D radius) {
			return PI * radius.doubleValue() * radius.doubleValue()
					* length.floatValue();
		}
	}

//	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		GenericsX<String> my_gen = new GenericsX<>("test");
		GenericsX<String>.Box<Integer> my_box = my_gen.new Box<>(6);
		System.out.println(my_box.area(2.9, 3.3));

	}

}
