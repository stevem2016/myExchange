package edu.acc.java;

/**
 * 
 Loan amortization Start with a loan amount, a 6 month term, some rational
 * interest rate Calculate payment to pay off loan in 6 months, including
 * interest Display principle balance for each of 6 months
 * 
 * Note: use the formula at
 * https://en.wikipedia.org/wiki/Amortization_calculator Hint: To exponentiate,
 * use Math.pow(a, b) where a is raised to the b power
 */

public class LoanAmortization {

	public static void main(String[] args) {

		/*
		 * 1) Define constants (interestRate, initialAmount, numberMonths) 2)
		 * Compute payment using the wiki formula 3) In a loop, subtract the
		 * payment from the outstanding amount and print it along with the month
		 * number 1,2,3...6 4) Stop when the outstanding amount is less than the
		 * payment (that is the final payment)
		 */

		double balance = 1000;
		System.out.printf("Initial balance is %.2f\n", balance);
		double rate = 0.0195; // 1.95% APR
		System.out.printf("APR interest rate is %s\n", rate);
		double num_payments = 6;
		System.out.printf("Number of payments is %s\n", num_payments);

		// payment calculation

		rate /= 12; // adjust to a monthly rate
		double partial = Math.pow(1 + rate, num_payments) - 1;
		double payment_amount = balance * (rate + (rate / partial));
		System.out.printf("Payment amount is $%.2f\n", payment_amount);
		int i = 1;

		// amortization schedule

		while (i <= num_payments) {
			double interest_paid = balance * rate;
			balance += interest_paid; // pay interest for the month
			balance -= payment_amount; // apply payment
			System.out.printf("\nRemaining balance after month: %d -> $%.2f",
					i, balance);
			i++;
		}
	}

}
