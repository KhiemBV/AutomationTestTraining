package btvnday4;

import java.util.Random;

public class Developer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee dev = new Employee();
		dev.setId(1);
		dev.setName("Aladeen");
		
		int salary = dev.getSalary();
		System.out.println("id: "+dev.getId()+'\n' + "name: "+dev.getName()+'\n' + "salary: "+salary+" VND");
		
		comment(salary);
	}
	
	public static void comment(int salary) {
		System.out.print("nhan xet ve luong: ");
		if (salary < 5000000) System.out.println("thap");
		else if (5000000 <= salary && salary <= 10000000) System.out.println("trung binh");
		else System.out.println("cao");
	}
}

class Employee {
	private int id;
	private String name;
	private int salary;
	
	Employee() {
		Random rd = new Random();
		this.salary = rd.nextInt(1000000, 15000000);
	}
	
	Employee(int salary) {
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
}