package it.xpug.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IEmployeeRepository {

	public void dowloadDataEmployee() throws ParseException, IOException;
	public ArrayList<Employee> getListEmployeeBirthday(XDate date);
}
