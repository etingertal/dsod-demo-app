package io.github.anantharajuc.sbmwa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.infra.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.repository.AddressRepository;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.AddressService;

@CacheConfig(cacheNames={"address"}) // tells Spring where to store cache for this class
@Service
public class AddressServiceImpl implements AddressService
{
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	/*
	 * The findAllAddress() call will first check the cache, "address" before actually invoking the method and then caching the result.
	 * If the "address" cache contains the required result, the result is returned and the method is not invoked.
	 */
	@Override
	@Cacheable 
	public List<Address> findAllAddress() 
	{
		return addressRepository
				.findAll();
	}

	@Override
	public Address findAddressById(Long id) 
	{
		return addressRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
	}

	@Override
	public Person findPersonByAddressId(Long id) 
	{
		return personRepository
				.findPersonByAddressId(id);
	}
}
