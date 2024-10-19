package j241014;

public class Circle {
	
	int radius;
	String name;
	
	public Circle() { // 생성자 함수 (Constructor)
		radius = 1;
		name = "";
	}
	
	public Circle(int r) { // 생성자 함수 오버로딩 (Function OverLoading)
		radius = r;
		name = "";
	}
	
	public Circle(int r, String n) { // 생성자 함수 오버로딩 (Function OverLoading)
		radius = r;
		name = n;
	}
	
	public double getArea() {
		
		return 3.14 * radius * radius;
	}
	
	public double getAround() {
		return 2 * 3.14 * radius;
	}
	
	public void printline() {
		System.out.println("-----------------------------------------");
	}
	
	public void copyrights() {
		System.out.println("program maker : lee");
		System.out.println("email : @gmail.com");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle pizza = new Circle(); // 기본 생성자 함수를 활용해서 객체 생성
		pizza.name = "피자";
		Circle donut = new Circle(5); // 오버로딩 된 생성자 함수를 활용해서 객체 생성
		donut.name = "도넛";
		Circle coin = new Circle(2, "코인"); // 오버로딩 된 생성자 함수를 활용해서 객체 생성
		
		pizza.copyrights();
		pizza.printline();
		
		System.out.println(pizza.name + "의 반지름" + pizza.radius);
		System.out.println(donut.name + "의 반지름" + donut.radius);
		System.out.println(coin.name + "의 반지름" + coin.radius);		
		
		donut.printline();
		System.out.println(pizza.name + "의 너비" + pizza.getArea());
		System.out.println(donut.name + "의 너비" + donut.getArea());
		System.out.println(coin.name + "의 너비" + coin.getArea());
		
		coin.printline();
		System.out.println(pizza.name + "의 둘레" + pizza.getAround());
		System.out.println(donut.name + "의 둘레" + donut.getAround());
		System.out.println(coin.name + "의 둘레" + coin.getAround());
	}

}
