package io.github.anantharajuc.sbmwa.service.impl;

import javax.transaction.Transactional;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.GenderEnum;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class PersonServiceImplTest 
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonServiceImpl personServiceImpl;
	
	@DisplayName("Return Saved Person from Service Layer")
	@Test
	void getPersonById_forSavedPerson_isReturned()
	{
		//given
		Person john = Person.builder().name("testUser").email("domain@example.com").mobileNumber("5987587458").address(null).gender(GenderEnum.MALE).isAdult(true).build();
		Address johnAddress = Address.builder().city("Bangalore").zipcode("578947").person(john).build();		
		john.setAddress(johnAddress); 	
		Person savedPerson = personRepository.save(john);

		//when
		Person person = personServiceImpl.getPersonById(savedPerson.getId());
		
		//then
		BDDAssertions.then(savedPerson.getId()).isNotNull();
		BDDAssertions.then(person.getName()).isEqualTo("testUser");
	}
}
