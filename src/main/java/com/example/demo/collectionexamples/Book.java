package com.example.demo.collectionexamples;

import java.util.Objects;
import java.util.UUID;

public class Book {

    private final UUID id = UUID.randomUUID();
    private String name;
    private Author author;
    private BookType bookType;
    private int sellCount;

    public Book() {
    }

    private Book(BookBuilder builder) {
        this.name = builder.name;
        this.author = builder.author;
        this.bookType = builder.bookType;
        this.sellCount = builder.sellCount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Book Builder class
     */
    public static class BookBuilder {
        private String name;
        private Author author;
        private BookType bookType;
        private int sellCount;

        public BookBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder author(Author author) {
            this.author = author;
            return this;
        }

        public BookBuilder bookType(BookType bookType) {
            this.bookType = bookType;
            return this;
        }

        public BookBuilder sellCount(int sellCount) {
            this.sellCount = sellCount;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
