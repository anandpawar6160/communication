package com.mail.comunication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.comunication.module.Input;
import com.mail.comunication.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService service;

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestBody Input input){

       return service.sendMail(input.getTo(),input.getSubject(),input.getBody());
    }


}
