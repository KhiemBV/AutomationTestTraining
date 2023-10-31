package btvnday5;

import java.util.Scanner;

public class Application {
	// tao co so du lieu bang linked list
	static int numberOfEmployee = 0;
	static Employee first = new Employee(0, "", "");
	static Employee last = first;

	public static void addFirst(int id, String name, String department) {
		first = new Employee(id, name, department);
		last = first;
		numberOfEmployee++;
	}

	public static void addEmployee(int id, String name, String department) {
		Employee newEmployee = new Employee(id, name, department);
		last.nextEmployee = newEmployee;
		last = newEmployee;
		numberOfEmployee++;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuous = true;
		int choice = 0;
		int id = 0;
		String name = "";
		String department = "";

		while (continuous) {
			System.out.println("Chọn chức năng mà bạn mong muốn (nhập số):");
			System.out.println("1. Nhập thông tin nhân viên \n2. In danh sách nhân viên \n3. Thoát");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("\nThông tin nhân viên mới:");
				System.out.println("Nhập ID: ");
				id = scanner.nextInt();
				System.out.println("Nhập tên: ");
				name = scanner.next();
				System.out.println("Nhập phòng ban (dev/tester/ba):");
				department = scanner.next();
				if (numberOfEmployee == 0)
					addFirst(id, name, department);
				else
					addEmployee(id, name, department);
				System.out.println("Nhập thành công!\n");
				break;
			case 2:
				if (numberOfEmployee == 0) { 
					System.out.println("\nDanh sách trống không\n");
					break;
				}
				System.out.println("\nDanh sách nhân viên: ");
				Employee temp = first;
				for (int i = 0; i < numberOfEmployee; i++) {
					System.out.println(temp.getId() + " " + temp.getName() + " " + temp.getDepartment());
					temp = temp.nextEmployee;
				}
				System.out.println();
				break;
			case 3:
				System.out.println("Thoát chương trình!");
				continuous = false;
				break;
			default:
				System.out.println("\nChưa có chức năng khác, xin chọn lại\n");
				break;
			}
		}
		scanner.close();
	}
}
