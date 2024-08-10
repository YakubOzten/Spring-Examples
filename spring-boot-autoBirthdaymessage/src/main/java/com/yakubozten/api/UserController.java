package com.yakubozten.api;


import com.yakubozten.entity.User;
import com.yakubozten.service.EmailService;
import com.yakubozten.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;



    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }



//    @GetMapping("/sendTestMessage")
//    public String sendTestMessage() {
//        try {
//            emailService.sendWhatsAppMessage("+15005550006", "This is a test message");
//            return "Test message sent successfully!";
//        } catch (Exception e) {
//            return "Failed to send test message: " + e.getMessage();
//        }
//    }
}
