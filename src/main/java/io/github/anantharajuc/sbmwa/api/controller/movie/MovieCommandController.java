package io.github.anantharajuc.sbmwa.api.controller.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.domain.dto.request.MovieCreateRequest;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.service.impl.MovieServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="MovieCommandController", description = "Set of public APIs, for managing Movies.")
@RestController
@RequestMapping("/api/person")
public class MovieCommandController 
{
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	@PostMapping(value = "/{id}/movies", consumes = "application/json")
    public Movie createMovie(@PathVariable Long id, @RequestBody MovieCreateRequest request) 
    {
		return movieServiceImpl.createMovieForPerson(id, request);  
    }
}
