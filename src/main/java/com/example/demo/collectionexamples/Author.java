package com.example.demo.collectionexamples;

import java.util.Objects;
import java.util.UUID;

public class Author {

    private final UUID id = UUID.randomUUID();
    private String name;
    private String age;
    private int rating;

    public Author(){}

    private Author(AuthorBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.rating = builder.rating;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Author Builder class
     */
    public static class AuthorBuilder {
        private String name;
        private String age;
        private int rating;

        public AuthorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AuthorBuilder age(String age) {
            this.age = age;
            return this;
        }

        public AuthorBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Author build(){
            return new Author(this);
        }
    }

}
