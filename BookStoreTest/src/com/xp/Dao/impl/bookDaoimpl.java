package com.xp.Dao.impl;

import java.util.Map;

import com.xp.Bean.Book;
import com.xp.BookDao.BookDao;
import com.xp.bookDB.BookDb;

public class bookDaoimpl implements BookDao {

	@Override
	public Map<String, Book> findAllBooks() {
		//Êý¾Ý¿â²Ù×÷
		return BookDb.findAllBooks();
	}
	
	
	@Override
	public Book findBookById(String bookId) {
		// TODO Auto-generated method stub
		return BookDb.findBookById(bookId);
	}



}
