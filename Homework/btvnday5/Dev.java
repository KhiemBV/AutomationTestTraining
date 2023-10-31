package btvnday5;

public class Dev extends Employee {
	private String department = "dev";

	public Dev(int id, String name) {
		super(id, name, name);
	}

	public String getDepartment() {
		return department;
	}

}
