package com.yakubozten.service;

import com.yakubozten.entity.User;
import com.yakubozten.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
}
