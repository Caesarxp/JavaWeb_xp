package com.xp.bookDB;

import java.util.LinkedHashMap;
import java.util.Map;
import com.xp.Bean.*;

public class BookDb {
	private static  Map<String,Book> books=new LinkedHashMap<String, Book>();
	static{
		books.put("001", new Book("001", "978-7-5086-4505-6", "你的孤独，虽败犹荣", "刘同",39.8f, "中信出版社"));
		books.put("002", new Book("002", "978-7-5086-4505-7", "天才在左，疯子在右", "高铭",19.8f, "中信出版社"));
		books.put("003", new Book("003", "978-7-5086-4505-8", "人间词话", "王国维",7.8f, "中信出版社"));
		books.put("004", new Book("004", "978-7-5086-4505-9", "沉默的大多数", "王小波",14.8f, "中信出版社"));
		books.put("005", new Book("005", "978-7-5086-4505-5", "狼图腾", "姜戎",10.0f, "中信出版社"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
}
