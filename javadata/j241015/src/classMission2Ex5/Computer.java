package classMission2Ex5;

public class Computer {
	int os;
	int ram;

	public Computer(int os, int ram) {
		this.os = os;
		this.ram = ram;
	}

	public static final String[] osType = { "윈도11", "애플 OS X", "안드로이드" };

	public void print() {
		System.out.println("운영체제: " + osType[os] + ", 메인메모리: " + ram + "GB");
	}

}
