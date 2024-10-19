package Task;

public class Account {

	private int id;
	private String password;
	private String ownerName;
	private int balance;

	public Account(int id, String password, String ownerName) { // 생성자 메서드
		this.id = id;
		this.password = password;
		this.ownerName = ownerName;
		this.balance = 0;
	}

	public void deposit(int d) { // 입금함수
		balance += d;
	}

	public int withdraw(int w, String p) { // 출금함수
		if (isCorrectPassword(p)) { // 비밀번호 확인
			if (balance >= w && w > 0) { // 출금금액 확인
				balance -= w;
			} else { // 잔고부족
				System.out.println("출력금액이 잘못되었습니다");
			}
			return balance;
		} else { // 비밀번호 틀림
			System.out.println("잘못된 비밀번호입니다.");
			return -1;
		}
	}

	public int checkBalance(String c) {
		if(isCorrectPassword(c)) {
		return balance;
		}
		System.out.println("잘못된 비밀번호입니다.");
		return -1;
	}

	private boolean isCorrectPassword(String i) {
		return this.password.equals(i);
	}


	}

