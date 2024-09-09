package io.github.anantharajuc.sbmwa.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import io.github.anantharajuc.sbmwa.api.controller.movie.MovieQueryController;
import io.github.anantharajuc.sbmwa.api.hateoas.common.SimpleIdentifiableRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Movie;

@Component
public class MovieRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Movie>
{
	public MovieRepresentationModelAssembler() 
	{
		super(MovieQueryController.class);
	}
	
	@Override
	public void addLinks(EntityModel<Movie> resource)
	{
		super.addLinks(resource);
		
		resource.add(linkTo(methodOn(MovieQueryController.class).getAllMoviesByPersonId(resource.getContent().getId())).withRel("persons")); 
	}
	
	@Override
	public void addLinks(CollectionModel<EntityModel<Movie>> resources) 
	{
		super.addLinks(resources);
		
		resources.add(linkTo(methodOn(RootController.class).root()).withRel("root"));
	}
}
