package it.xpug.birthday_greetings;

import java.util.List;
import javax.mail.MessagingException;

public class BirthdayService {

	private IEmployeeRepository repository;
	private IEmailService messageService;
	
	public BirthdayService(IEmployeeRepository repository,IEmailService messageService) {
		this.repository = repository;
		this.messageService = messageService;
	}
	
	public void sendGreetings(XDate today) throws MessagingException {
		List<Employee> employees = repository.getListEmployeeBirthday(today);
		
		for (Employee employee : employees) {
			Greetings greetings = new Greetings(employee);
			messageService.send(greetings);
		}
	}
}
