package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.Dto.Email;
import com.accolite.coursemanagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController()
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
//    @PostMapping
//    public void sendMail(@RequestBody Email email){
//        System.out.println(email);
//        emailService.sendSimpleEmail(email.getEmail(),email.getBody(),email.getSubject());
//    }
    @PostMapping
    public void sendMail(@RequestBody Email[] emails){
        Arrays.asList(emails).forEach(email -> emailService.sendSimpleEmail(email.getEmail(),email.getBody(),email.getSubject()));
    }

}
