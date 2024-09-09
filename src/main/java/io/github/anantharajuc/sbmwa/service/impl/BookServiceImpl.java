package io.github.anantharajuc.sbmwa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.infra.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.repository.BooksRepository;
import io.github.anantharajuc.sbmwa.service.BookService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@CacheConfig(cacheNames={"book"}) // tells Spring where to store cache for this class
public class BookServiceImpl implements BookService
{
	@Autowired
	private BooksRepository booksRepository;
	
	@Override
	@Cacheable 
	//The findAllBooks() call will first check the cache, "book" before actually invoking the method and then caching the result.
	//If the "book" cache contains the required result, the result is returned and the method is not invoked.
	public List<Books> findAllBooks() 
	{
		log.info("-----> findAllBooks service");
		
		return booksRepository.findAll();
	}

	@Override
	public Books findBookById(Long id) 
	{
		log.info("-----> findBookById service");
		
		return booksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
	}
}
