package classMission2Ex3;

public class SalaryMan {
	int salary = 2300000;

	public SalaryMan() {
		salary = 2300000;
	}

	public SalaryMan(int salary) {
		this.salary = salary;
	}

	public int getAnnualGross() {
		return salary * 17;
	}

}