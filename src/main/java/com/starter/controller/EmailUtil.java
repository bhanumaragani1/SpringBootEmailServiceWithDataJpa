package com.starter.controller;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender mailsender;

	public boolean send(String to, String subject, String text,
//			String []cc
//			String []bcc
			MultipartFile file) {
		boolean flag = false;
		try {			
			MimeMessage msg = mailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, file != null ? true : false);
			helper.setTo(to);
			helper.setFrom("bhanu.maragani1@gmail.com");
			helper.setSubject(subject);
			helper.setText(text);
			if(file!=null)
				helper.addAttachment(file.getOriginalFilename(),file);
			mailsender.send(msg);
			flag = true;
		} catch (MessagingException e) {
			flag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
