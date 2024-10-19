package j241011;

import java.util.Scanner;

public class ArrayAccess {

	public static void main(String[] args) {

//		int intArray [] = new int [5];
//		int myArray [] = intArray;
//		
//		intArray[2] = 10;
//		System.out.println(intArray[2]);
//		System.out.println(myArray[2]);
//		
//		intArray[2] = 100;
//		System.out.println(intArray[2]);
//		System.out.println(myArray[2]);

		Scanner scanner = new Scanner(System.in);
		
		int intArray[] = new int[5];
		int max = 0; // 현재 가장 큰 수
		
		System.out.println("양수 5개를 입력하세요.");
		
		for (int i = 0; i < 5; i++) {
			intArray[i] = scanner.nextInt();
			if (intArray[i] > max)
				max = intArray[i]; // max 변경
		}
		System.out.print("가장 큰 수는 " + max + "입니다.");
		scanner.close();
	}

}
