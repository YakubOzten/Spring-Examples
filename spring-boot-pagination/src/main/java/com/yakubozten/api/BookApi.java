package com.yakubozten.api;

import com.yakubozten.model.Book;
import com.yakubozten.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {

    private  final BookRepository bookRepository;
    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pagesize,@RequestParam Integer page){

        Pageable pageable = PageRequest.of(page,pagesize);
return bookRepository.findAll(pageable);
    }

    @GetMapping("/p")
    public List<Book> pagination(Pageable pageable){
        //Total Elements count query
        List<Book> books = bookRepository.findAll(pageable).getContent().stream().collect(Collectors.toList());
        List<Book> bookss = new ArrayList<>(bookRepository.findAll(pageable).getContent());
        return bookss;
    }
    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
