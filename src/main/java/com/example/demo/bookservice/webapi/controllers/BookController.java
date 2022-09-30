package com.example.demo.bookservice.webapi.controllers;

import com.example.demo.bookservice.webapi.dtos.BookDTO;
import com.example.demo.bookservice.webapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(consumes = MediaType.ALL_VALUE)
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }
}
