package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.domain.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, JpaSpecificationExecutor<Person>
{
	//validated on startup
	//custom method name - automatically derives sql query from method name
	Person getPersonByName(String name);
	
	//validated on startup
	//custom Java Persistence Query Language (JPQL) - creates queries against entities to store in RDB 
	@Query(value = "Select p from Person p") 
	List<Person> getAllPersonByName();
	
	//not validated on startup - prime candidates for integration tests
	//using native sql targeted at a DB table
	@Query(value = "SELECT * FROM person WHERE address_id = :address_id",nativeQuery = true) 
	@Transactional(readOnly=true)
	Person findPersonByAddressId(@Param("address_id") Long address_id);
}