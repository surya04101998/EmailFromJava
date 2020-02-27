package com.mail.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHandler {
	public static void sendMail( String toAddress,
           String subject, String message) throws AddressException,
           MessagingException {
		
		FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream("C:\\Users\\839843\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\mailSetup\\src\\main\\resources\\mailsetup.properties");
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } 
	     try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      

       Session session = Session.getDefaultInstance(prop);

       Message msg = new MimeMessage(session);

       msg.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user")));
       InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
       msg.setRecipients(Message.RecipientType.TO, toAddresses);
       msg.setSubject(subject);
       msg.setSentDate(new Date());
       msg.setText(message);

       Transport t = session.getTransport("smtp");
       t.connect(prop.getProperty("mail.smtp.user"), prop.getProperty("password"));
       t.sendMessage(msg, msg.getAllRecipients());
       t.close();

   }

}
