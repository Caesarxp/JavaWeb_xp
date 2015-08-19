		package com.xp.service;

import java.util.Map;

import com.xp.Bean.Book;
import com.xp.Bean.Cart;

public interface bookService {
	/*
	 * 查询所有的书
	 */
	public Map<String,Book> findAllBooks();
	/*
	 * 根据id查询
	 */
	public Book findBookById(String bookId);
	/*
	 * 每次购买时
	 * 增加购物项
	 */
	public void addBookCart(Cart cart, Book book);
	/*改变每一个购物项的数量
	 * 
	 */
	public void changeCartItemNum(Cart cart, String bookId,int num);
	/*
	 * 删除购物项
	 */
	public void delOneCartItem(Cart cart, String bookId);
}
