package it.xpug.birthday_greetings;

import javax.mail.MessagingException;

public interface IEmailService {
	public void send(Greetings greetings) throws MessagingException;
}
