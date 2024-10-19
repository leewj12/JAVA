package myclass;

public class Rectangle {
	int width;
	int height;

	int getArea() {
		return width * height;
	}
	
	void setwidth(int w) {
		width = w;
	}
	
	int getwidth() {
		return width;
	}
	
	void setheight(int h) {
		height = h;
	}
	
	int getheight() {
		return height;
	}
	
	int getarea2() {
		return getwidth() * getheight();
	}
	
}
