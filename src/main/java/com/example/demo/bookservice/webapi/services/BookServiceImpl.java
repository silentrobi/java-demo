package com.example.demo.bookservice.webapi.services;

import com.example.demo.bookservice.webapi.daos.BookDAO;
import com.example.demo.bookservice.webapi.dtos.BookDTO;
import com.example.demo.bookservice.webapi.entities.Author;
import com.example.demo.bookservice.webapi.entities.Book;
import com.example.demo.bookservice.webapi.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO, BookMapper bookMapper) {
        this.bookDAO = bookDAO;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> getBooks() {
        return bookMapper.map(bookDAO.getBooks());
    }

    @Override
    public Book getBook(UUID id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void saveOrUpdateBook(Book book) {
        bookDAO.saveOrUpdateBook(book);
    }

    @Override
    public Set<Book> getBooksByAuthorName(String authorName) {
        return bookDAO.getBooksByAuthorName(authorName);
    }

    @Override
    public Map<Author, Set<Book>> getBooksByAuthor() {
        return bookDAO.getBooksByAuthorV2();
    }

    @Override
    public Author findHighRatedAuthor() {
        return bookDAO.findHighRatedAuthor();
    }

    @Override
    public int findAuthorTotalBookSell(UUID authorId) {
        return bookDAO.findAuthorTotalBookSell(authorId);
    }
}
