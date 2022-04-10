package com.uphill.web.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private final static String userName = "dk02039";
	private final static String password = "jbyrldzwzwvldrqp";
	private final static String host = "smtp.gmail.com";
	private final static int port = 587;
	
	public static void sendEmail(String email, String subject, String content) {
		
		try {
	// 3-2) Property에 SMTP 서버 정보를 설정한다.(예:구글 SMTP 서버 정보를 설정)
			Properties properties = System.getProperties(); // java.util
			
			// starttls Command를 사용할 수 있게(=enable) 설정
			properties.put("mail.smtp.starttls.enable", "true"); // gmail은 무조건 true 고정
			
			// SMTP 서버 주소
			properties.put("mail.smtp.host", host); // "smtp.gmail.com"
			
			// auth Command를 사용하여 사용자 인증을 할 수 있게 설정
			properties.put("mail.smtp.auth", "true"); // gmail은 무조건 true 고정

			// 포트번호 설정
			properties.put("mail.smtp.port", port); // gmail의 포트 = "587"
			
			// jdk 높은 버전에서는 TLS버전문제 때문에 넣어줘야함
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // ★★교재 없는 내용 추가함
			
	/* 
	 * 3-3) SMTP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성한다.
	 *      메일을 전송하는 역할을 하는 단위인 Session객체 생성(SMTP서버정보, 사용자인증정보)
	 */
			Session session = Session.getDefaultInstance(properties, 
					new Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(userName, password);
						}
					});
	/*
	 *  3-4) Message 클래스의 객체를 사용하여 수신자와 제목, 내용의 메세지를 작성
	 *       생성한 Session객체를 사용하여 전송할 Message객체를 생성하여  3-5)에서 수신주소, 수신자 메일주소, 제목, 내용, 날짜를 작성한다.
	 */
			Message message = new MimeMessage(session); // javax.mail.message, javax.mail.internet.MimeMessage
		
	// 3-5) Transport 클래스를 사용하여 작성한 메세지를 전달한다.
			// 메일을 송신할(=보낼) 송신주소 생성
			Address sender = new InternetAddress(userName); // javax.mail
			
			// 메일을 수신할(=받는) 수신주소 생성
			// 수신자 메일주소-한명일 때
			Address receiver = new InternetAddress(email); // javax.mail
			
			// 메일 전송에 필요한 값 설정
			message.setHeader("content-type", "text/html;charset=UTF-8");
			message.setFrom(sender); // 송신주소 입력
			
			// 수신자 메일주소-한명일 때
			message.addRecipient(Message.RecipientType.TO, receiver); // 수신자 메일주소
			
			message.setSubject(subject); // 메일 제목 셋팅
			message.setContent(content, "text/html;charset=UTF-8"); // 메일 내용 셋팅
			message.setSentDate(new java.util.Date()); // 날짜 생성하여 셋팅
			
			Transport.send(message); // message를 메일로 전송
			
		} catch(SecurityException|MessagingException e) {
			e.printStackTrace();
		}
	}
}
