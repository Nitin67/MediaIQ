//package com.walmart.demo;
//
//import java.util.Properties;
//import javax.activation.*;
//import javax.mail.*;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class SendEmail {
////
//	public static void main(String[] args) {
//		String to = "nitinmmcool@gmail.com";
//		String from = "nitincouponstore@gmail.com";
//		String host = "smtp.gmail.com";
//		Properties properties = System.getProperties();
//		properties.setProperty("mail.smtp.starttls.enable", "true");
//		properties.setProperty("mail.smtp.host", host);
//		properties.setProperty("mail.smtp.port", "587");
//		properties.setProperty("mail.smtp.auth", "true");
//		// PasswordAuthentication passauthenticator = new
//		// PasswordAuthentication(from, "couponstore");
//		Authenticator authenticator = new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("nitincouponstore@gmail.com",
//						"couponstore");
//
//			}
//		};
//		Session session = Session.getInstance(properties, authenticator);
//		MimeMessage message = new MimeMessage(session);
//		try {
//			message.setFrom(new InternetAddress(from));
//			message.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse(to));
//			message.setSubject("This is subject Line");
//			message.setText("This is actual message");
//			Transport.send(message);
//			System.out.println("message Sent Successfully");
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//}
