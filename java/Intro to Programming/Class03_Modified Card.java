package edu.acc.java;

import java.util.Random;

/**
 * Demo Card class for Lab1 + lecture
 * 
   1. Extend the code we developed during lecture for Card arrays to assign a random name in the default constructor. 
      Use an array of names (at least 6) to choose from

   2. Test your changes to verify behavior as predicted.
 * 
 * @author pi
 *
 */
public class Card  {

	Random rand = new Random();
	/*
	 * this is a complex variable that...
	 */
	private int age; // default is zero 

	/*
	 * same thing
	 */
	public String name;  // default is null

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * my fancy getter for age (Not!)
	 */
	public int getAge() { 
		return age; 
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * default constructor
	 */
	public Card() {
		this.name = "Bob";
	}

	public Card(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public Card(String name) {
		this.age = rand.nextInt(150);
		this.name = name;
		System.out.println("new Card age= " + this.age +
				" and name = " + this.name);
	}

	public static void main(String[] args) {
		/*
		 * creating 10 instances of Card
		 */
		Card[] cards = new Card[10];
		
		for (int i=0; i < cards.length; i++) {
		    cards[i] = new Card("Jane");
		}
		/*
		 * Look for youngest age and name
		 */
		int youngestAge = cards[0].getAge();
		String youngestName = cards[0].getName();
		
		for (int i=0; i < cards.length; i++) {
			if (cards[i].getAge() < youngestAge) {
				youngestAge = cards[i].getAge();
				youngestName = cards[i].getName();
			}
		}
		
		System.out.println("youngest age is " + youngestAge
				+ " for person named " + youngestName);

	}

}
Status API Training Shop Blog About Pricing
© 2016 GitHub, Inc. Terms Privacy Security Co
