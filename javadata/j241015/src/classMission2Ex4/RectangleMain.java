package classMission2Ex4;

public class RectangleMain {

	public static void main(String[] args) {

		Rectangle rc = new Rectangle(3.82, 8.65);
		
		Rectangle rc2 = new Rectangle();
		rc2.height=12.0;
		rc2.width=3;
		
		System.out.println("면적: " + rc.getArea());
		System.out.println("둘레: " + rc.getCircumference());
		
		System.out.println("면적: " + rc2.getArea());
		System.out.println("둘레: " + rc2.getCircumference());
	}

}
