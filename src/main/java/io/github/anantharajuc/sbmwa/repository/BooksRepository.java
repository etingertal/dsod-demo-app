package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.domain.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>
{
	@Query(value = "SELECT * FROM books WHERE person_id = :person_id",nativeQuery = true) 
	@Transactional(readOnly=true)
    List<Books> getBooksByPersonId(@Param("person_id") Long person_id);

	Books getBookByTitle(String title); 
}
