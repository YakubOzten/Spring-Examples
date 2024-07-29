package com.yakubozten.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yakubozten.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
