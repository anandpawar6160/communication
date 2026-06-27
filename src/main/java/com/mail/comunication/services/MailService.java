package com.mail.comunication.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {


    @Autowired
    JavaMailSender sender;

    public ResponseEntity<?> sendMail(String to, String subject, String body){
        try{
          SimpleMailMessage send =  new SimpleMailMessage();
            send.setTo(to);
            send.setSubject(subject);
            send.setText(body);
            sender.send(send);
            return ResponseEntity.ok("mail send successfully ");
        } catch (Exception e) {
            log.error("Exception while mail send", e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }


    public static class DTO {
    }
}
