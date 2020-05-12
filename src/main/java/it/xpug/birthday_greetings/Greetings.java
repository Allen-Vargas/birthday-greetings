package it.xpug.birthday_greetings;

public class Greetings {
	private String originEmail;
	private String destinationEmail;
	private String subject;
	private String message;
	
	public Greetings (Employee employee) {
		initializeData(employee);
	}
	
	public void initializeData (Employee employee) {
		this.originEmail = employee.getEmail();
		this.destinationEmail = "sender@here.com";
		this.subject = "Happy Birthday!";
		initializeMessage(employee);
	}
	
	public void initializeMessage (Employee employee) {
		this.message = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
	}
	
	
	public String getDestinationEmail () {
		 return this.destinationEmail;
	}
	
	public String getOriginEmail () {
		 return this.originEmail;
	}
	
	public String getSubject () {
		 return this.subject;
	}
	
	public String getMessage () {
		 return this.message;
	}
}
