package com.example.demo.collectionexamples;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Library {

    private Map<UUID, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public Library(final Map<UUID, Book> books) {
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
}
