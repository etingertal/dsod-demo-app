package io.github.anantharajuc.sbmwa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.domain.model.Person;

public interface PersonService 
{
	List<Person> getAllPersons();
	
	Person getPersonById(Long id);
	
	Person savePerson(Person person);
	
	ResponseEntity<?> delete(Long id);
	
	Person updatePerson(Long personId, Person personDetails);
	
	List<Books> findPersonsBooks(Long id);
	
	List<Movie> findPersonMovies(Long id);
	
	Address findPersonsAddress(Long id);
}