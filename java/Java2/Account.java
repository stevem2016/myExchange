package edu.acc.java;

/**
 * LAB: Account class
 * 
 * - Create a class representing a bank account. The class should have state
 * instance variables for the account balance and owners name - Class should
 * have methods to: set the account owners name deposit to the account withdraw
 * from the account (make sure account does not overdraw) - Print account status
 * on one line (name and balance) - In your main() create (2) Account objects
 * with different names and balances - Deposit to the first account, then
 * withdraw less than the account balance - Print the first account balance -
 * Deposit to the second account, then withdraw more than the account balance
 * (app should print an error message and not do the withdrawal) - Withdraw from
 * the second account an amount less than the balance - Print the balance of the
 * second account
 * 
 * @author pi
 *
 */

public class Account {

	// Instance variables
	float balance = 0;
	String owner_name = "Unknown";

	public void set_owner_name(String new_name) {
		// Sets instance owner name
		if (new_name != null) {
			owner_name = new_name;
		}
	}

	public boolean deposit(float deposit_amount) {
		// Deposit to account; return true if successful, else false
		if (deposit_amount > 0f) {
			balance += deposit_amount;
			return true;
		}
		System.out.println("\nDeposit error (negative amount) on account: " + owner_name);
		return false;
	}

	public boolean withdraw(float withdraw_amount) {
		// Withdraw from account; return true if successful, else false
		if (withdraw_amount > 0f) {
			float test_balance = balance - withdraw_amount;
			if (test_balance > 0f) {
				balance = test_balance;
				return true;
			}
		}
		System.out.println("\nOverdrawn on account: " + owner_name);
		return false;
	}

	public void account_status() {
		System.out.printf("\nAccount Owner: %s Balance: %.2f ", owner_name,
				balance);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Instantiate and drive the class
		Account acct1 = new Account();
		Account acct2 = new Account();

		acct1.set_owner_name("Kobalt Goop");
		acct2.set_owner_name("Tricia Goop");

		acct1.deposit(2000f);
		acct1.withdraw(1000f);
		acct1.account_status();
		acct2.deposit(2000f);
		acct2.withdraw(3000f);
		acct2.withdraw(400f);
		acct2.account_status();
	}

}
