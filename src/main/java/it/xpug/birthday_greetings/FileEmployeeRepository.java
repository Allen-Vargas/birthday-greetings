package it.xpug.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class FileEmployeeRepository implements IEmployeeRepository {

	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private String nameFile;
	
	public FileEmployeeRepository(String nameFile) throws ParseException, IOException{
		this.nameFile=nameFile;
		dowloadDataEmployee();
	}
	
	public void dowloadDataEmployee() throws ParseException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader(nameFile));
		String str = "";
		str = in.readLine(); // skip header
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
			employees.add(employee);
		}
	}

	public ArrayList<Employee> getListEmployeeBirthday(XDate date) {
		// TODO Auto-generated method stub
		ArrayList <Employee> listEmployeesBirthday  = new ArrayList<Employee>();
		for (Employee employee : employees) {
			if (employee.isBirthday(date)) {
				listEmployeesBirthday.add(employee);
			}
		}
		return listEmployeesBirthday;
	}

}
