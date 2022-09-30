package com.example.demo.bookservice.webapi.mapper;

import com.example.demo.bookservice.webapi.configuration.MapperConfiguration;
import com.example.demo.bookservice.webapi.dtos.AuthorDTO;
import com.example.demo.bookservice.webapi.entities.Author;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface AuthorMapper {

    AuthorDTO mapToDTO(Author author);

    Author mapFromDTO(AuthorDTO author);
}
