package com.hervey.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hervey.app.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();

	Book findAllById(Long id);

	List<Book> findByDescriptionContaining(String search);

	Long countByTitleContaining(String search);

	Long deleteByTitleStartingWith(String search);

}
