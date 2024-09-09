package io.github.anantharajuc.sbmwa.domain.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.domain.model.GenderEnum;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import lombok.AccessLevel;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class PersonCreateRequest 
{
	Long id;
	String name;
	String email;
	String mobileNumber;
	GenderEnum gender;
	int age;
	Date dob;
	Boolean isAdult;
	Address address;
	Set<Books> books;
	List<Movie> movies;
} 