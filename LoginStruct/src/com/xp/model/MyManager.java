package com.xp.model;

import com.xp.util.NullUserException;

public class MyManager {
	
	private static MyManager instance=new MyManager();
	
	private MyManager(){
		
	}
	
	public  synchronized static MyManager getInstance(){
		return instance;
		
	}
	public void login(String name,String password) throws NullUserException{
		if(!"xp".equals(name)){
			throw new NullUserException();
		}
		else if(!"123456".equals(password)){
			throw new NullUserException();
		}
		
	}

}
