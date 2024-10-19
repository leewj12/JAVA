package test2;

// A ~ Z 65 ~ 90
// a ~ z 97 ~ 122

public class ArrayParameter {
	
	static void convertAlpha(char a[]) {//	알파벳 영문자 대소문자 변환(대문자 -> 소문자로, 소문자 -> 대분자로)
		// 대소문자 구분
		for (int i = 0; i < a.length; i++) {
			int temp = (int) a[i];
			if (64 < temp && temp < 91) {
				temp += 32;
			} else if (96 < temp && temp < 123) {
				temp -= 32;
			}
			a[i] = (char) temp;
		}
	}

	static void replaceSpace(char a[]) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == ' ')
				a[i] = ',';
	}

	static void printCharArray(char a[]) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}


	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);

		convertAlpha(c); // 대소문자 변환 함수 호출
		printCharArray(c);

	}

}
