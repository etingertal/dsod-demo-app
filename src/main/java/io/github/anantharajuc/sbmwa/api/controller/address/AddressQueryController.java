package io.github.anantharajuc.sbmwa.api.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.api.APIutil;
import io.github.anantharajuc.sbmwa.api.hateoas.AddressRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.api.hateoas.PersonRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.service.impl.AddressServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Address Query Controller
 *
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 *
 */
@Tag(name="AddressQueryController", description = "Set of public APIs, for querying Address.")
@RestController
@RequestMapping(value="/api")
public class AddressQueryController 
{
	@Autowired
	AddressServiceImpl addressServiceImpl;
	
	@Autowired
	private PersonRepresentationModelAssembler personRepresentationModelAssembler;
	
	@Autowired
	private AddressRepresentationModelAssembler addressRepresentationModelAssembler;

	/**
     * Retrieve all addresses.
     * 
     * @return List<Address> with all Restaurants
     */
	@GetMapping(value = "/addresses", produces = "application/json")
	public ResponseEntity<CollectionModel<EntityModel<Address>>> getAllAddress()
	{
		return new ResponseEntity<>(addressRepresentationModelAssembler.toCollectionModel(addressServiceImpl.findAllAddress()), APIutil.returnHttpHeaders(), HttpStatus.OK); 
	}
	
	/**
     * Get an Address by id.
     * 
     * @param id. The Address id         
     * @return the Address for the given id
     */
	@GetMapping(value = "/addresses/{id}", produces = "application/json")
	public ResponseEntity<EntityModel<Address>> getAddressById(@PathVariable("id") Long id)
	{
		return new ResponseEntity<>(addressRepresentationModelAssembler.toModel(addressServiceImpl.findAddressById(id)), APIutil.returnHttpHeaders(), HttpStatus.OK); 
	}
	
	/**
     * Get a Person by Address Id.
     * 
     * @param id. The Address id         
     * @return the Person for the given Address id
     */
	@GetMapping(value = "/addresses/{id}/person", produces = "application/json")
	public ResponseEntity<EntityModel<Person>> getPersonByAddressId(@PathVariable("id") Long id)
	{
		return new ResponseEntity<>(personRepresentationModelAssembler.toModel(addressServiceImpl.findPersonByAddressId(id)), APIutil.returnHttpHeaders(), HttpStatus.OK); 
	}
}
