package io.github.anantharajuc.sbmwa.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.api.controller.address.AddressQueryController;
import io.github.anantharajuc.sbmwa.api.controller.book.BookQueryController;
import io.github.anantharajuc.sbmwa.api.controller.movie.MovieQueryController;
import io.github.anantharajuc.sbmwa.api.controller.person.PersonQueryController;

@RestController
public class RootController 
{
	@SuppressWarnings("rawtypes")
	@GetMapping("/")
	public ResponseEntity<RepresentationModel> root()
	{
		RepresentationModel<?> model = new RepresentationModel<>();
		
		model.add(linkTo(methodOn(RootController.class).root()).withSelfRel());
		
		model.add(linkTo(methodOn(PersonQueryController.class).getAllPersons(null, null, null)).withRel("persons"));
		model.add(linkTo(methodOn(MovieQueryController.class).findAllMovies()).withRel("movies"));
		model.add(linkTo(methodOn(BookQueryController.class).getAllBooks()).withRel("books")); 
		model.add(linkTo(methodOn(AddressQueryController.class).getAllAddress()).withRel("address"));
						
		return ResponseEntity.ok(model);
	}
}
