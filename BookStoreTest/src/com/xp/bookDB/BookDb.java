package com.xp.bookDB;

import java.util.LinkedHashMap;
import java.util.Map;
import com.xp.Bean.*;

public class BookDb {
	private static  Map<String,Book> books=new LinkedHashMap<String, Book>();
	static{
		books.put("001", new Book("001", "978-7-5086-4505-6", "��Ĺ¶����������", "��ͬ",39.8f, "���ų�����"));
		books.put("002", new Book("002", "978-7-5086-4505-7", "������󣬷�������", "����",19.8f, "���ų�����"));
		books.put("003", new Book("003", "978-7-5086-4505-8", "�˼�ʻ�", "����ά",7.8f, "���ų�����"));
		books.put("004", new Book("004", "978-7-5086-4505-9", "��Ĭ�Ĵ����", "��С��",14.8f, "���ų�����"));
		books.put("005", new Book("005", "978-7-5086-4505-5", "��ͼ��", "����",10.0f, "���ų�����"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
}
