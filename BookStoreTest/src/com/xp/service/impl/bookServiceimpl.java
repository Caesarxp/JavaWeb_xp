package com.xp.service.impl;

import java.util.Map;

import com.xp.Bean.Book;
import com.xp.Bean.Cart;
import com.xp.Bean.CartItem;
import com.xp.BookDao.BookDao;
import com.xp.Dao.impl.bookDaoimpl;
import com.xp.service.bookService;

public class bookServiceimpl implements bookService{
	private BookDao Dao=new bookDaoimpl();
	@Override
	public Map<String, Book> findAllBooks() {
		// TODO 业务逻辑
		return Dao.findAllBooks();
	}

	@Override
	public Book findBookById(String bookId) {
		// TODO Auto-generated method stub
		return Dao.findBookById(bookId);
	}

	@Override
	public void addBookCart(Cart cart, Book book) {
		// TODO 添加到购物车
		cart.addBookCart(book);
		
	}

	@Override
	public void changeCartItemNum(Cart cart, String bookId, int num) {
		// TODO Auto-generated method stub
		CartItem item=cart.getItems().get(bookId);
		item.setNum(num);
	}

	@Override
	public void delOneCartItem(Cart cart, String bookId) {
		// TODO Auto-generated method stub
		cart.getItems().remove(bookId);
		
	}

}
