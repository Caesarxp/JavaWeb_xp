package com.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginActionForm extends ActionForm {

private String username;
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
} 
@Override
public void reset(ActionMapping arg0, HttpServletRequest arg1) {
	System.out.println("--------LoginActionForm.reset()------");
}
@Override
public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	System.out.println("--------LoginActionForm.validate()------");
	return null;
}
}