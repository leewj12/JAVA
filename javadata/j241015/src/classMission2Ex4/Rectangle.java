package classMission2Ex4;

public class Rectangle {
	double width;
	double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
	}

	public double getArea() {
		return width * height;
	}

	public double getCircumference() {
		return (width + height) * 2;
	}
}
