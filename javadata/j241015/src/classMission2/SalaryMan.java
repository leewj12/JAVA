package classMission2;

public class SalaryMan {
	private int salary = 2300000;
	
	public SalaryMan(int salary){
		this.salary = salary;
	}
	
	public SalaryMan(){
		salary = 2300000;
	}
	
	public int getAnnualGross() {
		return salary * 17;
	}

}