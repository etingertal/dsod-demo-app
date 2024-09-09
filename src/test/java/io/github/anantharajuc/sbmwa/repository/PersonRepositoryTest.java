package io.github.anantharajuc.sbmwa.repository;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.GenderEnum;
import io.github.anantharajuc.sbmwa.domain.model.Person;

@SpringBootTest
public class PersonRepositoryTest 
{
	@Autowired
	private PersonRepository personRepository;

	@Test
	void testGetPersonByName_returnsPersonDetails()
	{
		//given
		Person john = Person.builder().name("testUser").email("domain@example.com").mobileNumber("5987587458").address(null).gender(GenderEnum.MALE).isAdult(true).build();
		Address johnAddress = Address.builder().city("Bangalore").zipcode("578947").person(john).build();		
		john.setAddress(johnAddress); 	
		Person savedPerson = personRepository.save(john);
		
		//when
		Person person = personRepository.getPersonByName("testUser");
		
		//then
		BDDAssertions.then(savedPerson.getId()).isNotNull();
		BDDAssertions.then(person.getName()).isEqualTo("testUser");
	}
	
	@Test
	void testFindPersonByAddressId_returnsPersonDetails()
	{
		//given
		Person john = Person.builder().name("John").email("domain@example.com").mobileNumber("5987587458").address(null).gender(GenderEnum.MALE).isAdult(true).build();
		Address johnAddress = Address.builder().city("Bangalore").zipcode("578947").person(john).build();		
		john.setAddress(johnAddress); 	
		Person savedPerson = personRepository.save(john);
		
		//when
		Person person = personRepository.findPersonByAddressId(savedPerson.getAddress().getId());
		
		//then
		BDDAssertions.then(person.getId()).isNotNull();
		BDDAssertions.then(person.getAddress().getId()).isEqualTo(john.getAddress().getId()); 
	}
}
