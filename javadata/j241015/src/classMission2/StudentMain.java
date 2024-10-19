package classMission2;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student1 = new Student();
		student1.department = "정보통신";
		student1.id = 1234;
		System.out.println("학과: " + student1.department + " 학번: " + student1.id);
		
		Student student2 = new Student();
		student2.department = "화학";
		student2.id = 11;
		System.out.println("학과: " + student2.department + " 학번: " + student2.id);
		

	}

}
