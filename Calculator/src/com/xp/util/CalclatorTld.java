package com.xp.util;

public class CalclatorTld {
	
	public static String sum(double v1,double v2,String flag){
		double result = 0;
		if("+".equals(flag)){
			result=v1+v2;
		}
		else if("-".equals(flag)){
			result=v1-v2;
		}
		else if("*".equals(flag)){
			
			result=v1*v2;
		}
		else if("/".equals(flag)){
		
			result=v1/v2;
		}
		return result+"";
	}
	public static String say(){
		return "hello";
		
	}
}
