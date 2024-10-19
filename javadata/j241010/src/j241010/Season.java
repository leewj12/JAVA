package j241010;

import java.util.Scanner;

//ctrl + shift + f 소스코드 자동 정리
//ctrl + shift + o 패키지, 클래스, 모듈 자동 포함
public class Season {

	public static void main(String[] args) {
		// 표준 입력 스트림 객체(키보드)생성 scanner가 가르킴
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("월(1~12)을 입력하시오:");
//		int month = scanner.nextInt(); // 정수로 월 입력
//		
//		switch(month) {
//		case 3:
//		case 4:
//		case 5:
//		System.out.println("봄입니다.");
//		break;
//		
//		case 6: case 7: case 8:
//		System.out.println("여름입니다.");
//		break;
//		
//		case 9: case 10: case 11:
//		System.out.println("가을입니다.");
//		break;
//		
//		case 12: case 1: case 2:
//		System.out.println("겨울입니다."); 
//		break;
//		
//		default:
//		System.out.println("잘못된 입력입니다.");
//		}
//		scanner.close();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("월(1~12)을 입력하시오:");
		int month = scanner.nextInt(); // 정수로 월 입력
		
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("봄입니다.");
			}
		
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("여름입니다.");
			}
		
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("가을입니다.");
			}
		
		else if(month == 12 || month == 1 || month == 2) {
			System.out.println("겨을입니다.");
			}
		else {
		System.out.println("잘못된 입력입니다.");
		}
		scanner.close();

}

}
