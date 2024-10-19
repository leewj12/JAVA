package test3;

public class AccountMain {

	public static void main(String[] args) {
		
		Account account = new Account(1, "password!@#", "Park"); // 계좌 생성

		account.deposit(100000); // 10만원 입금

		System.out.println(account.checkBalance("password!@#")); // 잔액 확인

		account.withdraw(20000, "password!@#"); // 2만원 출금

		System.out.println(account.checkBalance("password!@#")); // 잔액 확인
	}

}
