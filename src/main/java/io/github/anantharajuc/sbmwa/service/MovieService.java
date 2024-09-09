package io.github.anantharajuc.sbmwa.service;

import java.util.List;

import io.github.anantharajuc.sbmwa.domain.dto.request.MovieCreateRequest;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.domain.model.Person;

public interface MovieService 
{
	List<Movie> getMoviesByPersonId(Long id);
	
	List<Movie> findAllMovies();
	
	Movie getMovieById(Long id);
	
	Movie createMovieForPerson(Long id, MovieCreateRequest movie);
	
	List<Person> getPersonsByMovieId(Long id);
}
