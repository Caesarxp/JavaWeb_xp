		package com.xp.service;

import java.util.Map;

import com.xp.Bean.Book;
import com.xp.Bean.Cart;

public interface bookService {
	/*
	 * ��ѯ���е���
	 */
	public Map<String,Book> findAllBooks();
	/*
	 * ����id��ѯ
	 */
	public Book findBookById(String bookId);
	/*
	 * ÿ�ι���ʱ
	 * ���ӹ�����
	 */
	public void addBookCart(Cart cart, Book book);
	/*�ı�ÿһ�������������
	 * 
	 */
	public void changeCartItemNum(Cart cart, String bookId,int num);
	/*
	 * ɾ��������
	 */
	public void delOneCartItem(Cart cart, String bookId);
}
