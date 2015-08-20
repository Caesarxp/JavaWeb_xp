package com.zte.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.DynaValidatorForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	 	//ActionMessages mess=new ActionMessages();
	 	DynaValidatorForm daf=(DynaValidatorForm)form;
		String name=(String)daf.get("username");
		String pass=(String)daf.get("userpass");
		System.out.println(name);
		System.out.println(pass);
		if("admin".equals(name)&&"adminadmin".equals(pass))
		{
			return mapping.findForward("ok");
		}
//		if(name.equals("zah"))
//		{
//			ActionMessage msg=new ActionMessage("loginForm.error.username");
//			mess.add("loginForm.error.username",msg);
//			saveMessages(request,mess);
//			return mapping.findForward("mess");
//		}
		return mapping.findForward("no");
	}

}
