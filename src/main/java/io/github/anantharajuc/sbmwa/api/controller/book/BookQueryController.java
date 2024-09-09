package io.github.anantharajuc.sbmwa.api.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.api.hateoas.BooksRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="BookQueryController", description = "Set of public APIs, for querying Books.")
@RestController
@RequestMapping(value="/api")
public class BookQueryController 
{
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@Autowired
	BooksRepresentationModelAssembler booksRepresentationModelAssembler;
	
	@GetMapping(value = "/bookses", produces = "application/json")
	public ResponseEntity<CollectionModel<EntityModel<Books>>> getAllBooks()
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(booksRepresentationModelAssembler.toCollectionModel(bookServiceImpl.findAllBooks()), headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/bookses/{id}", produces = "application/json")
	public ResponseEntity<EntityModel<Books>> getBookById(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(booksRepresentationModelAssembler.toModel(bookServiceImpl.findBookById(id)), headers, HttpStatus.OK);
	}
}
