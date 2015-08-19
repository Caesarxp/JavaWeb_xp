package com.xp.BookDao;

import java.util.Map;

import com.xp.Bean.Book;

public interface BookDao {
	/**
	 * 进行功能规范
	 */
	/*
	 * 查询所有的书籍
	 */
	
	public Map<String,Book> findAllBooks();
	/*
	 * 根据id查询书籍
	 */
	public Book findBookById(String bookId);
}
