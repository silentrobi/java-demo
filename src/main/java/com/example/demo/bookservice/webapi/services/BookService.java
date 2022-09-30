package com.example.demo.bookservice.webapi.services;

import com.example.demo.bookservice.webapi.dtos.BookDTO;
import com.example.demo.bookservice.webapi.entities.Author;
import com.example.demo.bookservice.webapi.entities.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface BookService {

    List<BookDTO> getBooks();

    Book getBook(UUID id);

    void saveOrUpdateBook(Book book);

    Set<Book> getBooksByAuthorName(String authorName);

    Map<Author, Set<Book>> getBooksByAuthor();

    Author findHighRatedAuthor();

    int findAuthorTotalBookSell(UUID authorId);
}
