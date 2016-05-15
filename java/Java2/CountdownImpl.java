package edu.acc.java;

public class CountdownImpl implements Countdown {

	/**
	 * CountdownImpl class using an interface
	 * 
	 * 1) Write an interface Countdown of one method:
	 *       String liftoff(int startCount);
	 * 2) Write a class called CountdownImpl that implements Countdown
	 *    a) liftoff method should print the count on each iteration
	 *    (stretch goal: pause a second between each count)
	 *    b) return the String "liftoff!" 
	 *    
	 * @param args from command line
	 */
	
	public static void main(String[] args) {
		CountdownImpl launch = new CountdownImpl();
		System.out.println(launch);  // toString() in action
		System.out.println(launch.liftoff(count));  // liftoff() in action
	}

	@Override
	public String liftoff(int count) {
		for (int i = count; i >= 0; i--) {
			System.out.println(i);
			// sleep a second
			try {
				Thread.sleep(1000);
			}
			catch (Exception ex) {
				System.out.println("Sleep exception: " + ex);
			}
		}
		return "liftoff!";
	}

	@Override
	public String toString() {
		return "Liftoff in " + count + " seconds";
	}

}
