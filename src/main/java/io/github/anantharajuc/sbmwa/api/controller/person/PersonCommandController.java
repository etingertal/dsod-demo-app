package io.github.anantharajuc.sbmwa.api.controller.person;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.domain.dto.request.PersonCreateRequest;
import io.github.anantharajuc.sbmwa.domain.dto.request.PersonUpdateRequest;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.impl.PersonServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="PersonCommandController", description = "Set of public APIs, for managing Person.")
@RestController
@RequestMapping("/api/person")
public class PersonCommandController 
{
	@Autowired
	PersonServiceImpl personServiceImpl;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	ModelMapper modelMapper;

	/**
     * Create/Update a person. 
     * Returned person will have the auto-generated id if its newly created.
     * 
     * @param person. The person to create
     * @return the created person
     */
	@PostMapping(consumes = "application/json")
    public ResponseEntity<Person> createPerson(@RequestBody PersonCreateRequest request) 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 

		Person person = modelMapper.map(request, Person.class);
				
		return new ResponseEntity<>(personServiceImpl.savePerson(person), headers, HttpStatus.CREATED);
    }
	
	/**
     * Update a person. Hero must exist for id.
     * 
     * @param id. The id of the person to be updated
     * @param person. The person values to be updated
     * @throws ResourceNotFoundException if person not found.
     */
	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @Valid @RequestBody PersonUpdateRequest request)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 

		Person person = modelMapper.map(request, Person.class);
		
		return new ResponseEntity<>(personServiceImpl.updatePerson(id, person), headers, HttpStatus.NO_CONTENT);	
	}
	
	/**
     * Delete Person
     * 
     * @param id. The persons id.
     * @throws ResourceNotFoundException if the person is not found.
     */
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 

		return new ResponseEntity<>(personServiceImpl.delete(id), headers, HttpStatus.NO_CONTENT);
    }
} 