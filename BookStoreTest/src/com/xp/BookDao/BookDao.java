package com.xp.BookDao;

import java.util.Map;

import com.xp.Bean.Book;

public interface BookDao {
	/**
	 * ���й��ܹ淶
	 */
	/*
	 * ��ѯ���е��鼮
	 */
	
	public Map<String,Book> findAllBooks();
	/*
	 * ����id��ѯ�鼮
	 */
	public Book findBookById(String bookId);
}
