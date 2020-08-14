package com.equifax.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.equifax.library.model.Book;

public interface BookRepo extends CrudRepository<Book, String> {

	void deleteById(int id);

}
