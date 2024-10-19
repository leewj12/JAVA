package classMission2;

public class Computer {
	
	public static final String[] osType = {"윈도11", "애플", "안드로이드"};
	
	private int os;
	private int ram;
	
	public Computer(int os, int ram) {
		this.os = os;
		this.ram = ram;
	}
	
	public void print() {
		String ost = osType[os];
		System.out.println("운영체제: " + ost + ", 메인메모리: " + ram + "GB");
	}

}
