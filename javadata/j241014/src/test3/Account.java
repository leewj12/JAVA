package test3;

public class Account {
	
	private int id;
	private String password;
	private String ownerName;
	private int balance;
	
	public Account(int id, String password, String ownerName){
		this.id = id;
		this.password = password;
		this.ownerName = ownerName;
		this.balance = 0;
	}

	public void deposit(int d) {
		if(d > 0) {
			balance += d;
		}
	}
	
	public int withdraw(int w, String password) {
		if(w > 0 && w <= balance && isCorrectPassword(password)) {
			return balance -= w;
		}
		return -1;
	}
	
	public int checkBalance(String password) {
		if(isCorrectPassword(password)) {
			return balance;
		}
		return -1;
	}
	
	public boolean isCorrectPassword(String password) {
		return this.password.equals(password);
	}
}
