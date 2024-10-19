package classMission2Ex1;

public class StudentMain {

	public static void main(String[] args) {
		
		// Student 객체(st1) 생성
		Student st1 = new Student();
		
		st1.department = "유아교육과";
		st1.id = 12345;
		
		Student st2 = new Student("정보통신학과", 20142950);
		
		System.out.println("학번 " +st1.id + "의 학과는 " + st1.department + "입니다.");
		System.out.println("학번 " +st2.id + "의 학과는 " + st2.department + "입니다.");
		

	}

}
