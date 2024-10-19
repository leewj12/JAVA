package classMission2Ex2;

public class Student {
	private String department;
	private int id;
	
	public Student(String department, int id) {
		this.department = department;
		this.id = id;
	}
	
	public Student() {}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
