package io.github.anantharajuc.sbmwa.domain.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import lombok.AccessLevel;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class PersonUpdateRequest 
{
	Long id;
	String name;
	String email;
	String mobileNumber;
	Address address;
	Set<Books> books;
	List<Movie> movies;
}
