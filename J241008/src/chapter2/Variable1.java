package chapter2;

public class Variable1 {
	public static void main(String[] args) {
		int level;              //정수형 변수 level을 선언
		level = 10;             //level 변수에 10을 대입
		System.out.println("게임 레벨 : "+level);
		
		int age = 25; // 4 byte 크기
		System.out.println("나이: "+age);
		
		short sVal = 10; // 2 byte 크기
		byte  bVal = 20; // 1 byte 크기
		System.out.println( sVal + bVal );
		
		int iVal_1 = 10;
		int iVal_2 = 20;
		
		int result = iVal_1 + iVal_2;
		System.out.println( result );
		
		result = iVal_1 - iVal_2;
		System.out.println( result );
		
		result = iVal_1 * iVal_2;
		System.out.println( result );
		
		result = iVal_1 / iVal_2;
		System.out.println( result );
		
		result = iVal_1 % iVal_2;
		System.out.println( result );
		
		double dval = 3.0; // 8 byte 크기
		double dresult;
		
		dresult = iVal_1 / dval;
		System.out.println( dresult );
		
		float fval = 3.0f; // 4 byte 크기
		float fresult;
		
		fresult = iVal_1 / fval;
		System.out.println( fresult );
		
		double dnum = 1;
		
		for(int i=0; i<10000; i++){
			dnum = dnum + 0.1;
		}
		System.out.println(dnum);
		
		int a = 65;
		int b = -66;
		
		char a2 = 65; // = char a2 = 'A';
		// char b2 = -66; ¿¡·¯ ³²  
		
		System.out.println((char)a);
		System.out.println((char)b);
		System.out.println((char)a2);
		
		byte bs1 = -128;
		byte bs2 = 127;
			
		System.out.println(bs1);
		System.out.println(bs2);
			
		short s = 32767;
		System.out.println(s);
		
		double dNum1 = 1.2;
		float fNum2 = 0.9F;

		int iNum3 = (int)dNum1 + (int)fNum2; // 1 + 0
		int iNum4 = (int)(dNum1 + fNum2); // (int)2.1
		System.out.println(iNum3); // 1
		System.out.println(iNum4); // 2
		
		int i = 10;
		var j = 10.0;
		var str = "hello";
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(str);
		
	}
}
