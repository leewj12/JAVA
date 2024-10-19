package classMission2;

public class PrivateStudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrivateStudent ps1 = new PrivateStudent();
		ps1.dpSetter("수학교육");
		ps1.idSetter(123);
		System.out.println("학과: " + ps1.dpGetter() + ", 학번: " + ps1.idGetter());

	}

}
