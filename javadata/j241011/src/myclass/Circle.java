package myclass;

public class Circle {
	int radius; // 원의 반지름을 저장하는 멤버 변수

	String name; // 원의 이름을 저장하는 멤버 변수

	public double getArea() {
		return 3.14 * radius * radius;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle pizza;
		pizza = new Circle(); // Circle 객체 생성
		pizza.radius = 10; // 피자의 반지름을 10으로 설정
		pizza.name = "자바피자"; // 피자의 이름 설정
		double area = pizza.getArea(); // 피자의 면적 알아내기
		System.out.println(pizza.name + "의 면적은 " + area);
		
		Circle donut = new Circle(); // Circle 객체 생성
		donut.radius = 2; // 도넛의 반지름을 2로 설정
		donut.name = "자바도넛"; // 도넛의 이름 설정
		area = donut.getArea(); // 도넛의 면적 알아내기
		System.out.println(donut.name + "의 면적은 " + area);
		
		Rectangle rect = new Rectangle(); // 객체 생성
		rect.width = 100;
		rect.height = 12;
		
		area = rect.getArea();
		System.out.println("가로 " + rect.width + ", 세로 " + rect.height + "인 사각형의 면적은 " + area);
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setName(String name) {
		this.name = name;
	}

}
