package myclass;

import java.util.Scanner;

public class Babygin {

	public static void main(String[] args) {

		int[] c = new int[12];

		int tri = 0;
		int run = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("0~9 사이의 숫자 카드 6개를 연속해서 적어주세요!\n 예)1 3 5 4 6 2 X 135462 O");
		int card = scanner.nextInt();
//		System.out.println(card);

		for (int i = 0; i < 6; i++) {
			int n = card % 10;
			c[n] += 1;
			card = card / 10;

//			System.out.println(c);
		}

		for (int i = 0; i < 10; i++) {
			if (c[i] >= 3) {
				c[i] -= 3;
				tri += 1;
				continue;
			}
			if (c[i] >= 1 && c[i + 1] >= 1 && c[i + 2] >= 1) {
				c[i] -= 1;
				c[i + 1] -= 1;
				c[i + 2] -= 1;
				run += 1;
				continue;
			}
		}

		if (run + tri == 2) {
			System.out.println("Baby Gin");
		} else {
			System.out.println("Lose");
		}

	}

}
