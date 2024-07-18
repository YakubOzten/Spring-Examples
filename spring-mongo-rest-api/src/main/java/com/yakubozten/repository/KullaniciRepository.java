package com.yakubozten.repository;

import com.yakubozten.entity.kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository<kullanici,String>{

}
