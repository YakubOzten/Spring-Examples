package com.yakubozten.repo;

import com.yakubozten.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book,Long> {

}
