package com.example.demo.bookservice.webapi.daos;

import com.example.demo.bookservice.webapi.entities.Author;
import com.example.demo.bookservice.webapi.entities.Book;
import com.example.demo.bookservice.webapi.entities.BookType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookDAO {

    private Map<UUID, Book> books = new HashMap<>();

    public BookDAO() {
        generateMockData();
    }

    public BookDAO(final Map<UUID, Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    public Book getBook(final UUID id) {
        return books.get(id);
    }

    public void saveOrUpdateBook(final Book book) {
        books.put(book.getId(), book);
    }

    public Set<Book> getBooksByAuthorName(final String authorName) {
        return books.values().stream().filter(book -> book.getAuthor().getName().equals(authorName)).collect(Collectors.toSet());
    }

    public Map<Author, Set<Book>> getBooksByAuthor() {
        final Map<Author, Set<Book>> result = new HashMap<>();
        books.values().stream().map(Book::getAuthor)
                .distinct()
                .forEach(author -> {
                    result.put(author, books.values().stream().filter(book -> book.getAuthor() == author).collect(Collectors.toSet()));
                });

        return result;
    }

    public Map<Author, Set<Book>> getBooksByAuthorV2() {
        return books.values().stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.toSet()));
    }

    public Author findHighRatedAuthor() {
        final var authors = books.values().stream().map(Book::getAuthor).sorted(Comparator.comparing(Author::getRating, Comparator.reverseOrder())).toList();
        if (authors.isEmpty()) return null;

        return authors.get(0);
    }

    public int findAuthorTotalBookSell(UUID authorId) {
        return books.values().stream()
                .filter(book -> book.getAuthor().getId() == authorId)
                .map(Book::getSellCount)
                .reduce(0, Integer::sum);
    }

    private void generateMockData() {
        final var author1 = new Author.AuthorBuilder().name("Tom hank").age("55").rating(5).build();
        final var author2 = new Author.AuthorBuilder().name("David Rauth").age("60").rating(4).build();
        final var author3 = new Author.AuthorBuilder().name("Whillam Trump").age("43").rating(3).build();

        final var book1 = new Book.BookDTOBuilder().name("Harry porter").author(author1).bookType(BookType.fiction).sellCount(30).build();
        final var book2 = new Book.BookDTOBuilder().name("Modern agriculture").author(author2).bookType(BookType.agriculture).sellCount(160).build();
        final var book3 = new Book.BookDTOBuilder().name("Science Today").author(author3).bookType(BookType.technology).sellCount(470).build();
        final var book4 = new Book.BookDTOBuilder().name("Wheat production").author(author1).bookType(BookType.agriculture).sellCount(230).build();
        final var book5 = new Book.BookDTOBuilder().name("Love").author(author2).bookType(BookType.romance).sellCount(730).build();
        final var book6 = new Book.BookDTOBuilder().name("Big bang").author(author3).bookType(BookType.technology).sellCount(340).build();
        final var book7 = new Book.BookDTOBuilder().name("Otoman").author(author1).bookType(BookType.history).sellCount(700).build();
        final var book8 = new Book.BookDTOBuilder().name("British India").author(author2).bookType(BookType.history).sellCount(430).build();
        final var book9 = new Book.BookDTOBuilder().name("You and me").author(author3).bookType(BookType.romance).sellCount(50).build();
        final var book10 = new Book.BookDTOBuilder().name("Lord of the ring").author(author1).bookType(BookType.fiction).sellCount(250).build();
        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);

        this.books = books.stream().collect(Collectors.toMap(Book::getId, book -> book));
    }
}
