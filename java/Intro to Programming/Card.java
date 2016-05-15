package edu.acc.java;

import java.util.Random;

/**
 * Demo Card class for Lab1 + lecture
 * 
 * 1) Create a class called Card with two attributes: 
       private int age;
       public String name;

   2) Write getter and setter methods for age e.g. 
       public int getAge() { code to return the age }
       public void setAge(int age) { code to set the age }

   3) In your main() method, create 10 instances of Card. 
      Set the age attribute for each Card with the setAge() method. Set the 
      name of each Card with the dot operator. Think about how you might keep
      those ten pointers. What if you had 1000 Cards?

   4) Now go through your cards and print name and age on the Card with 
      the youngest age. Use a relational operator to do this as follows:
         if (relational expression) 
           { block of code }
      What will you need to keep track of and change in the block?

    Stretch goal: use the java.util.Random class we saw in class to add a random number to the age in setAge()
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
