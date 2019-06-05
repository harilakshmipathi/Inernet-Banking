package com.HSBCBank.dao;

import java.util.Properties;
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage;

public class EmailSender{ public static void main(String args[]) { 
	String to = "receive@abc.om"; // sender email 
	String from = "sender@abc.com"; // receiver email 
	String host = "127.0.0.1"; // mail server host 

	java.util.Properties properties = System.getProperties(); 
	
	
	((System) properties).setProperty("mail.smtp.host", host); 
	Session session = Session.getDefaultInstance(properties);
	
	
	try {
		MimeMessage message = new MimeMessage(); 
	
message.setFrom(new InternetAddress()); // setting header fields 
message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
message.setSubject("Test Mail from Java Program"); // subject line 
	

message.setText("You can send mail from Java program by using mail API, "
		+ "but you need"
+ "couple of more JAR files e.g. smtp.jar and activation.jar"); // Send message 
Transport.send(message);
System.out.println("Email Sent successfully...."); 
} 
	catch (MessagingException mex) 
	{ 
		mex.printStackTrace(); 
		} 
	} 
}

