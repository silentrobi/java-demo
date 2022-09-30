package com.example.demo.bookservice.webapi.mapper;

import com.example.demo.bookservice.webapi.configuration.MapperConfiguration;
import com.example.demo.bookservice.webapi.dtos.BookDTO;
import com.example.demo.bookservice.webapi.entities.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(config = MapperConfiguration.class,
        uses = {AuthorMapper.class})
public abstract class BookMapper {

    @Mapping(source = "book.name", target = "bookName")
    @Mapping(source = "book.author", target = "bookAuthor")
    abstract BookDTO mapToDTO(Book book);

    @Mapping(source = "bookDTO.bookName", target = "name")
    @Mapping(source = "bookDTO.bookAuthor", target = "author")
    abstract Book mapFromDTO(BookDTO bookDTO);


    @AfterMapping
    public void mapPopularity(@MappingTarget BookDTO bookDTO){
            bookDTO
    }
    public List<BookDTO> map(final List<Book> demands) {
        return demands.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
