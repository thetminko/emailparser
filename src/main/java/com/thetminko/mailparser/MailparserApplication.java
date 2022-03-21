package com.thetminko.mailparser;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailparserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailparserApplication.class, args);
		parse();
	}

	private static void parse() {
		parseEmail('email1.eml');
		parseEmail('email2.eml');
	}

	private static void parseEmail(String filename) {
		Properties props = System.getProperties();
    props.put("mail.host", "smtp.dummydomain.com");
    props.put("mail.transport.protocol", "smtp");

    Session mailSession = Session.getDefaultInstance(props, null);
		InputStream source = classLoader.getResourceAsStream(filename);
    MimeMessage message = new MimeMessage(mailSession, source);


    System.out.println("Subject : " + message.getSubject());
    System.out.println("From : " + message.getFrom()[0]);
    System.out.println("--------------");
    System.out.println("Body : " +  message.getContent());
	}

}
