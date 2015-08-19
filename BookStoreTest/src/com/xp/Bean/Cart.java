package com.xp.Bean;

import java.util.LinkedHashMap;
import java.util.Map;
/*
 * ���ﳵ����������ļ�����
 */
public class Cart {
	//key��bookid��value��CartItem
	private Map<String,CartItem> items=new LinkedHashMap<String, CartItem>();
	private int num;//����
	private float price;//�ܼ�
	public Map<String, CartItem> getItems() {
		return items;
	}
//	public void setItems(Map<String, CartItem> items) {
//		this.items = items;
//	}
	public int getNum() {//TODO �˴�Ҫ��num��0������ÿ��ˢ��numֵ������session
		num=0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}
//	public void setNum(int num) {
//		this.num = num;
//	}
	public float getPrice() {//��getNum()����һ��
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
	 * ����������빺�ﳵ
	 */
	public void addBookCart(Book book){
		//�ж������֮ǰ��û�����
		if(items.containsKey(book.getId())){
			//�����������һ
				CartItem item=items.get(book.getId());
				item.setNum(item.getNum()+1);
		}else{
		//û�������������������빺�ﳵ��
			CartItem item=new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);//TODO �˴�������
		}
	}
}
