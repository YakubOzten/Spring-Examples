package com.yakubozten.service;

import com.yakubozten.entity.User;
import com.yakubozten.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BirthdayReminderService {

    private final UserRepository userRepository;

    private  final EmailService emailService;

    private  final WhatsappService whatsappService;

    @Scheduled(cron = "50 38 22 * * ?",zone = "Europe/Istanbul") // Her gün saat 09:00'da çalışır
    public  void sendBirthdayReminders(){
        System.out.println("birtday basladı");
        LocalDate today=LocalDate.now();
        System.out.println(today);
        List<User> users=userRepository.findByBirthDate(today);
        System.out.println(users);

        for (User user:users){
            System.out.println(user.getName());
            String subject = "Happy Birthday!";
            String message = "Happy Birthday " + user.getName() + "!";
            emailService.sendEmail(user.getEmail(),user.getName(),subject, message);
        }
    }

    @Scheduled(cron = "30 10 14 * * ?",zone = "Europe/Istanbul") // Her gün saat 09:00'da çalışır
    public  void sendBirthdayWpReminders(){
        System.out.println("birtday basladı");
        LocalDate today=LocalDate.now();
        System.out.println(today);
        List<User> users=userRepository.findByBirthDate(today);
        System.out.println(users);

        for (User user:users){
            System.out.println(user.getName());
            String subject = "Happy Birthday!";
            String messageText = "Happy Birthday " + user.getName() + "!";
            whatsappService.sendWhatsAppMessage(user.getContactNumber(),user.getSenderNumber(),messageText);
        }
    }
}
