package com.bjsxt.struts;

import org.apache.struts.action.ActionForm;

/**
 * ²âÊÔ¿Õ×Ö¶Î
 * @author Administrator
 *
 */
public class BlankFieldActionForm extends ActionForm {

	private String username;
	
	private int age;
    
	 private String password;
	
	private int[] productId;
	
	public int[] getProductId() {
		return productId;
	}

	public void setProductId(int[] productId) {
		this.productId = productId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

 
}
