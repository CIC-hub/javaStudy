package Java8特性;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
	
	public static List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee(1001, "a", 1, 11));
		list.add(new Employee(1002, "bb", 1, 22));
		list.add(new Employee(1003, "c", 3, 33));
		list.add(new Employee(1004, "ddd", 4, 44));
		list.add(new Employee(1005, "eee", 5, 55));
		list.add(new Employee(1006, "f", 6, 66));
		list.add(new Employee(1007, "g", 7, 77));
		list.add(new Employee(1008, "hhh", 8, 88));
		
		return list;
	}
}
