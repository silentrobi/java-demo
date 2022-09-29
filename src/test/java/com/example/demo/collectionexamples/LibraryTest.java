package com.example.demo.collectionexamples;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryTest {

    private Library library;

    private Author author1;
    private Author author2;
    private Author author3;

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private Book book7;
    private Book book8;
    private Book book9;
    private Book book10;

    @BeforeEach
    void testSetup() {
        author1 = new Author.AuthorBuilder().name("Tom hank").age("55").rating(5).build();
        author2 = new Author.AuthorBuilder().name("David Rauth").age("60").rating(4).build();
        author3 = new Author.AuthorBuilder().name("Whillam Trump").age("43").rating(3).build();

        book1 = new Book.BookBuilder().name("Harry porter").author(author1).bookType(BookType.fiction).sellCount(30).build();
        book2 = new Book.BookBuilder().name("Modern agriculture").author(author2).bookType(BookType.agriculture).sellCount(160).build();
        book3 = new Book.BookBuilder().name("Science Today").author(author3).bookType(BookType.technology).sellCount(470).build();
        book4 = new Book.BookBuilder().name("Wheat production").author(author1).bookType(BookType.agriculture).sellCount(230).build();
        book5 = new Book.BookBuilder().name("Love").author(author2).bookType(BookType.romance).sellCount(730).build();
        book6 = new Book.BookBuilder().name("Big bang").author(author3).bookType(BookType.technology).sellCount(340).build();
        book7 = new Book.BookBuilder().name("Otoman").author(author1).bookType(BookType.history).sellCount(700).build();
        book8 = new Book.BookBuilder().name("British India").author(author2).bookType(BookType.history).sellCount(430).build();
        book9 = new Book.BookBuilder().name("You and me").author(author3).bookType(BookType.romance).sellCount(50).build();
        book10 = new Book.BookBuilder().name("Lord of the ring").author(author1).bookType(BookType.fiction).sellCount(250).build();

        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);
        library = new Library(books.stream().collect(Collectors.toMap(Book::getId, book -> book)));
    }

    @Test
    public void getBooksTest() {
        final var result = library.getBooks();
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void getBookTest() {
        final var result = library.getBook(book1.getId());
        Assertions.assertEquals(book1.getName(), result.getName());
        Assertions.assertEquals(book1.getBookType(), result.getBookType());
    }

    @Test
    public void saveOrUpdateBookTest() {
        Book book = new Book.BookBuilder().name("Hulk").author(author1).bookType(BookType.fiction).sellCount(80).build();

        library.saveOrUpdateBook(book);
        var result = library.getBook(book.getId());

        Assertions.assertEquals(book.getId(), result.getId());
        Assertions.assertEquals(book.getName(), result.getName());


        library.saveOrUpdateBook(book1);
        result = library.getBook(book1.getId());

        Assertions.assertEquals(book1.getId(), result.getId());
        Assertions.assertEquals(book1.getName(), result.getName());
    }

    @Test
    public void getBooksByAuthorNameTest() {
        final var result = library.getBooksByAuthorName("Tom hank");

        Assertions.assertEquals(4, result.size());
    }

    @Test
    public void getBooksByAuthorTest() {
        final var result = library.getBooksByAuthor();

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(4, result.get(author1).size());
        Assertions.assertEquals(3, result.get(author2).size());
        Assertions.assertEquals(3, result.get(author3).size());
    }

    @Test
    public void getBooksByAuthorV2Test() {
        final var result = library.getBooksByAuthorV2();

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(4, result.get(author1).size());
        Assertions.assertEquals(3, result.get(author2).size());
        Assertions.assertEquals(3, result.get(author3).size());
    }

    @Test
    public void findHighRatedAuthorTest() {
        var result = library.findHighRatedAuthor();
        Assertions.assertEquals(author1, result);

        Library library = new Library();

        result = library.findHighRatedAuthor();
        Assertions.assertEquals(null, result);
    }

    @Test
    public void findAuthorTotalBookSell() {
        var result = library.findAuthorTotalBookSell(author1.getId());
        Assertions.assertEquals(1210, result);
    }
}
