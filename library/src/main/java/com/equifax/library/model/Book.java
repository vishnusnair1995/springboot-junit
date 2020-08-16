package com.equifax.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Book {
	@Id
	@GeneratedValue
	@Column(name="BOOK_ID")
	private int bookId;
	@Column(name="BOOK_NAME")
	private String bookName;
	@Column(name="BOOK_STATUS")
	private String bookStatus;
	@Column(name="USER_ID")
	private int userId;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserDetails(int userId) {
		this.userId = userId;
	}
	
}
