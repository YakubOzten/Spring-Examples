package com.yakubozten.repo;

import com.yakubozten.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByBirthDate(LocalDate birthDate);
}
