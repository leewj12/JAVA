package j241014;

// A ~ Z 65 ~
// a ~ z 97 ~

public class ArrayParameter {

	static void replaceSpace(char a[]) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == ' ')
				a[i] = ',';
	}

	static void printCharArray(char a[]) {
		for (int i=0; i<a.length; i++)
		System.out.print(a[i]);
		System.out.println();
	}
	
	static void Convertalpha(char a[]) {
		//	알파벳 영문자 대소문자 변환(대문자 -> 소문자로, 소문자 -> 대분자로)
	}
	
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
	
		Convertalpha(c); // 대소문자 변환 함수 호출
		printCharArray(c);
		
	}

}
