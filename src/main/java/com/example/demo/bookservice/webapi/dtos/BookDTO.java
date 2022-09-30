package com.example.demo.bookservice.webapi.dtos;

import com.example.demo.bookservice.webapi.entities.Author;
import com.example.demo.bookservice.webapi.entities.BookType;

import java.util.Objects;
import java.util.UUID;

public class BookDTO {
    private UUID id;
    private String bookName;
    private AuthorDTO bookAuthor;
    private BookType bookType;
    private int sellCount;

    private Popularity popularity;

    public BookDTO() {
    }

    private BookDTO(BookDTOBuilder builder) {
        this.bookName = builder.name;
        this.bookAuthor = builder.author;
        this.bookType = builder.bookType;
        this.sellCount = builder.sellCount;
    }

    public UUID getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setBookName(String name) {
        this.bookName = name;
    }

    public AuthorDTO getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(AuthorDTO author) {
        this.bookAuthor = author;
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
        BookDTO book = (BookDTO) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Book Builder class
     */
    public static class BookDTOBuilder {
        private String name;
        private AuthorDTO author;
        private BookType bookType;
        private int sellCount;

        public BookDTO.BookDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BookDTO.BookDTOBuilder author(AuthorDTO author) {
            this.author = author;
            return this;
        }

        public BookDTO.BookDTOBuilder bookType(BookType bookType) {
            this.bookType = bookType;
            return this;
        }

        public BookDTO.BookDTOBuilder sellCount(int sellCount) {
            this.sellCount = sellCount;
            return this;
        }

        public BookDTO build() {
            return new BookDTO(this);
        }
    }
}
