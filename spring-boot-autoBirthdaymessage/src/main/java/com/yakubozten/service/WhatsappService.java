package com.yakubozten.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class WhatsappService {


    @Value("${brevo.wp.api.rul}")
    private String brevoApiUrl;

    @Value("${brevo.api.key}")
    private String brevoApiKey;

    public void sendWhatsAppMessage(String contactNumber, String senderNumber,String messageText) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", brevoApiKey);

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("contactNumbers", new String[]{contactNumber});
        requestData.put("text", messageText);
        requestData.put("senderNumber", senderNumber);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestData, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                brevoApiUrl,
                HttpMethod.POST,
                request,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("WhatsApp mesajı başarıyla gönderildi.");
        } else {
            System.out.println("WhatsApp mesajı gönderimi sırasında bir hata oluştu: " + response.getBody());
        }
    }

}
