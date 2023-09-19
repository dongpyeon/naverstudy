package bit701.day0911;

public class Account3 {
	private int balance = 10000;

	public int getBalance() {
		return balance;
	}
	
	final int Min_BALANCE = 0;
	final int Max_BALANCE = 1000000;
	

	public void setBalance(int balance) {
		if (Min_BALANCE<balance && balance<Max_BALANCE) 
			this.balance = balance;
		else
			this.balance=this.balance;

	}
}
