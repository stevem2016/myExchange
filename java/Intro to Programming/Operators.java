package edu.acc.java;

import java.util.Scanner;

public class Operators {
	
public static void main(String[] args) {
    
	int answer = 0;
	System.out.print("Enter month: ");

	Scanner scan = new Scanner(System.in);
	String month = scan.next();
	
	switch (month.toLowerCase()) {
	case "january": answer = 1;
	                break;
	case "june": answer = 6;
	                break;
	case "august": answer = 8;
	                break;
	default: System.out.println("No match on month String");
	}
	
	if (answer != 0) {
	System.out.println("Month integer is " + answer);
	}
	
	String no_space = "3/10/2016";
	String[] date_array = no_space.split(""); // returns String[]
	for (String piece : date_array) {
		System.out.println(piece);
	}
	}

}
