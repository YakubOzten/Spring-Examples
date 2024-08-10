package com.yakubozten.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${brevo.api.key}")
    private String brevoApiKey;

    @Value("${brevo.api.url}")
    private String brevoApiUrl;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String toEmail,String toName, String subject, String text) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", brevoApiKey);

        Map<String, Object> emailData = new HashMap<>();
        Map<String, String> sender = new HashMap<>();
        sender.put("name", "yakub");
        sender.put("email", "yakubozten@gmail.com");
        emailData.put("sender", sender);

        Map<String, String> toRecipient = new HashMap<>();
        toRecipient.put("email", toEmail);
        toRecipient.put("name", toName);
        emailData.put("to", new Map[] { toRecipient });

        emailData.put("subject", subject);
        // Dinamik HTML içeriği
        String htmlContent = String.format("<html><head></head><body><p>Hello %s,</p><p>%s</p></body></html>", toName,text);
        emailData.put("htmlContent", htmlContent);;

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(emailData, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                brevoApiUrl ,
                HttpMethod.POST,
                request,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("E-posta başarıyla gönderildi.");
        } else {
            System.out.println("E-posta gönderimi sırasında bir hata oluştu: " + response.getBody());
        }
//        MimeMessage message = mailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom("79e66d005@smtp-brevo.com");
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(text, true); // true for HTML content
//
//            // Optional: Set sent date
//            message.setSentDate(new Date());
//
//            mailSender.send(message);
//            System.out.println("E-posta başarıyla gönderildi.");
//        } catch (MessagingException e) {
//            System.out.println("E-posta gönderimi sırasında bir hata oluştu: " + e.getMessage());
//        }
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(fromEmail);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        System.out.println("message:"+message);
//        mailSender.send(message);
    }

}
