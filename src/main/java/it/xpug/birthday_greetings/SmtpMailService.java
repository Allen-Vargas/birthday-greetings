package it.xpug.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpMailService implements IEmailService {
	int port;
	String host;
	Message msg;
	Session session;
	
	public SmtpMailService(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	public void send(Greetings greetings) throws MessagingException {
		// TODO Auto-generated method stub
		createMailSession();
		ConstructMessage(greetings);
		Transport.send(msg);
	}
	
	// Create a mail session
	public void createMailSession() {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "" + port);
		session = Session.getInstance(props, null);
	}
		
	// Construct the message
	public void ConstructMessage(Greetings greetings) throws AddressException, MessagingException {
		msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(greetings.getDestinationEmail()));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(greetings.getOriginEmail()));
		msg.setSubject(greetings.getSubject());
		msg.setText(greetings.getMessage());
		msg.saveChanges();
	}
}
