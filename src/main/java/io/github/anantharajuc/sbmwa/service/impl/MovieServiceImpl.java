package io.github.anantharajuc.sbmwa.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.domain.dto.request.MovieCreateRequest;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.infra.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.repository.MovieRepository;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.MovieService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@CacheConfig(cacheNames={"movie"}) // tells Spring where to store cache for this class
public class MovieServiceImpl implements MovieService
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<Movie> getMoviesByPersonId(Long id) 
	{
		log.info("-----> getMoviesByPersonId service");
		
		Person personOptional = personRepository.findById(id)
									.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		 
		return personOptional.getMovies();
	}

	@Override
	@CacheEvict(allEntries = true) 
	//@CacheEvict annotation is used to indicate the removal of one or more/all values so that fresh values can be loaded into the cache again.	
	public Movie createMovieForPerson(Long id, MovieCreateRequest request) 
	{
		log.info("-----> createMovieForPerson service");
		
		Person personOptional = personRepository.findById(id)
									.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		request.setPerson(personOptional); 
		
		Movie movie = modelMapper.map(request, Movie.class);
		
		return movieRepository.save(movie);
	}

	@Override
	@Cacheable 
	//The findAllMovies() call will first check the cache, "movie" before actually invoking the method and then caching the result.
	//If the "movie" cache contains the required result, the result is returned and the method is not invoked.
	public List<Movie> findAllMovies() 
	{
		log.info("-----> findAllMovies service");
		
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Long id) 
	{
		log.info("-----> getMovieById service");
		
		return movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
	}

	@Override
	public List<Person> getPersonsByMovieId(Long id) 
	{
		log.info("-----> getPersonsByMovieId service");
		
		return null;
	}
}
