package com.xp.Bean;

import java.util.LinkedHashMap;
import java.util.Map;
/*
 * 购物车：将购物项的加起来
 */
public class Cart {
	//key：bookid；value：CartItem
	private Map<String,CartItem> items=new LinkedHashMap<String, CartItem>();
	private int num;//总数
	private float price;//总价
	public Map<String, CartItem> getItems() {
		return items;
	}
//	public void setItems(Map<String, CartItem> items) {
//		this.items = items;
//	}
	public int getNum() {//TODO 此处要将num归0；以免每次刷新num值都存在session
		num=0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}
//	public void setNum(int num) {
//		this.num = num;
//	}
	public float getPrice() {//与getNum()方法一样
		price=0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}
//	public void setPrice(float price) {
//		this.price = price;
//	}
	/*
	 * 将购物项加入购物车
	 */
	public void addBookCart(Book book){
		//判断买的书之前有没有买过
		if(items.containsKey(book.getId())){
			//买过，数量加一
				CartItem item=items.get(book.getId());
				item.setNum(item.getNum()+1);
		}else{
		//没有买过，创建购物项，加入购物车中
			CartItem item=new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);//TODO 此处有问题
		}
	}
}
