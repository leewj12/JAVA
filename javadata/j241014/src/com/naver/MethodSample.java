package com.naver;

public class MethodSample {
	
	private int val1; //동일 클래스 내에서만 접근 가능한 변수
	int val2; // 동일 패키지 내에서만 접근 가능한 변수
	protected int val3; // 동일 패키지와 상속받은 클래스 까지만 접근 가능
	public int val4; // 모든 외부 패키지까지 접근 가능한 변수
	
	public int getSum(int i, int j) {
		val1 = i;
		val2 = j;
		return val1 + val2;
	}
	
	public int getSum(int i, int j, int k) {
		return i + j + k;
	}
	
	public double getSum(double i, double j) {
		return i + j;
	}
}
