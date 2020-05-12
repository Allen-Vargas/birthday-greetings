package it.xpug.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService();
		service.sendGreetings("employee_data.txt", new XDate(), "localhost", 25);
		
		/*/EmployeeRepository repository = new FileEmployeeRepostory("employee_data.txt");
		EmailService emailService = new SmtpMailService("localhost", 25);
		BirthdayService service = new BirthdayService(repository, emailService);
		service.sendGreetings(new XDate());/*/
	}

}
