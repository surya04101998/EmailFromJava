package com.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mail.services.MailHandler;

@SpringBootApplication
public class MailSetupApplication {

	public static void main(String[] args) {
		try {
			String receiver="someone@gmail.com";
			String subject="meanial";
			String content="really?";
			MailHandler.sendMail(receiver, subject, content);
			System.out.println("Mail sent succesfully");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(MailSetupApplication.class, args);
	}

}
