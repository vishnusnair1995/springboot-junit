package com.equifax.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equifax.library.model.Book;
import com.equifax.library.service.BookService;

@RestController
public class BookController {
@Autowired
private BookService bookService;

@RequestMapping(value="/addbook",method=RequestMethod.POST)
public String addBook(@RequestBody Book book) {
	Book book1 = bookService.addBook(book);
	 if(book1!=null) { 
    	 return "SUCESSFULLY ADDED TO DATABASE";
}
     else {    
         return "INSERT OPERATION FAILED";

     }
}
@RequestMapping(value="/deletebook/{id}",method=RequestMethod.DELETE)
public String deleteBook(@PathVariable int id) {
	bookService.deleteBook(id);
	return "SUCESSFULLY DELETED FROM DATABASE";

}
}
