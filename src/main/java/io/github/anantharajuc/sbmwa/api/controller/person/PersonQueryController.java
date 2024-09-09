package io.github.anantharajuc.sbmwa.api.controller.person;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.api.hateoas.AddressRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.api.hateoas.BooksRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.api.hateoas.MovieRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.api.hateoas.PersonRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.domain.util.PagingHeaders;
import io.github.anantharajuc.sbmwa.domain.util.PagingResponse;
import io.github.anantharajuc.sbmwa.service.impl.PersonServiceImpl;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Tag(name="PersonQueryController", description = "Set of public APIs, for querying Person.")
@RestController
@RequestMapping("/api")
public class PersonQueryController 
{
	@Autowired
	private PersonServiceImpl personServiceImpl;

	@Autowired
	private PersonRepresentationModelAssembler personRepresentationModelAssembler;
	
	@Autowired
	private AddressRepresentationModelAssembler addressRepresentationModelAssembler;
	
	@Autowired
	private BooksRepresentationModelAssembler booksRepresentationModelAssembler;
	
	@Autowired
	private MovieRepresentationModelAssembler movieRepresentationModelAssembler;
	
	public HttpHeaders returnHttpHeaders(PagingResponse response) 
	{
        HttpHeaders headers = new HttpHeaders();
        
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        
        return headers;
    }

	/**
     * Retrieve all persons
     * 
     * @return List<Person> with all persons
     */	
	@Transactional
	@GetMapping(value = "/persons", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CollectionModel<EntityModel<Person>>> getAllPersons(
    		@And({
    			@Spec(path = "id", params = "id", spec = Equal.class),
                @Spec(path = "name", params = "name", spec = Equal.class),
                @Spec(path = "email", params = "email", spec = Like.class),
                @Spec(path = "country", params = "country", spec = In.class),                
                @Spec(path = "createdDate", params = "createdDate", spec = Equal.class),
                @Spec(path = "createdDate", params = {"createdDateGt", "createdDateLt"}, spec = Between.class)
        }) Specification<Person> spec, Sort sort, @RequestHeader HttpHeaders headers) 
	{
		final PagingResponse response = personServiceImpl.get(spec, headers, sort);
		
		return new ResponseEntity<>(personRepresentationModelAssembler.toCollectionModel(response.getElements()), returnHttpHeaders(response), HttpStatus.OK); 
    }
	
	/**
     * Get a Person by id.
     * 
     * @param id. The persons id         
     * @return the person
     */	
	@Operation(summary = "Get a Person by id.")
	@ApiResponse(responseCode = "200", description = "Found the person", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))})
	@ApiResponse(responseCode = "404", description = "Person not found", content = @Content)
	@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content)
	@GetMapping(value = "/persons/{id}", produces = "application/json")
    public ResponseEntity<EntityModel<Person>> getPerson(@Parameter(description = "id of the Person to be searched") @PathVariable("id") Long id) 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 

        return new ResponseEntity<>(personRepresentationModelAssembler.toModel(personServiceImpl.getPersonById(id)), headers, HttpStatus.OK); 
    }
	
	@GetMapping(value = "/persons/{id}/books", produces = "application/json")
	public ResponseEntity<CollectionModel<EntityModel<Books>>> getPersonsBooks(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(booksRepresentationModelAssembler.toCollectionModel(personServiceImpl.findPersonsBooks(id)), headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/persons/{id}/movies", produces = "application/json")
	public ResponseEntity<CollectionModel<EntityModel<Movie>>> getPersonsMovies(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(movieRepresentationModelAssembler.toCollectionModel(personServiceImpl.findPersonMovies(id)), headers, HttpStatus.OK); 
	}

	@GetMapping(value = "/persons/{id}/address", produces = "application/json")
	public ResponseEntity<EntityModel<Address>> getPersonsAddress(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(addressRepresentationModelAssembler.toModel(personServiceImpl.findPersonsAddress(id)), headers, HttpStatus.OK); 
	}
}