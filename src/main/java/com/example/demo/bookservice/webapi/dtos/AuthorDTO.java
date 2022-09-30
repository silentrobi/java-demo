package com.example.demo.bookservice.webapi.dtos;

import java.util.Objects;
import java.util.UUID;

public class AuthorDTO {
    private UUID id;
    private String name;
    private String age;
    //private int rating;

    public AuthorDTO() {
    }

    private AuthorDTO(AuthorDTO.AuthorDTOBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        //this.rating = builder.rating;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO author = (AuthorDTO) o;
        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Author Builder class
     */
    public static class AuthorDTOBuilder {
        private String name;
        private String age;
        private int rating;

        public AuthorDTO.AuthorDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AuthorDTO.AuthorDTOBuilder age(String age) {
            this.age = age;
            return this;
        }

        public AuthorDTO.AuthorDTOBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public AuthorDTO build() {
            return new AuthorDTO(this);
        }
    }
}
