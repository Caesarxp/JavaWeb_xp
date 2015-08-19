  
     package forms;
     /**
      * 
      * @author Administrator
      * 收集管理员修改的密码信息
      */
     public class AdminPasswordForm {
     private int id;
     private String name;
     private String oldPw;
     private String newPw1;
     private String newPw2;
	 
     public AdminPasswordForm()
     {}
     
     public int getId() {
		return id;
	 }
	
     public void setId(int id) {
		this.id = id;
	 }
     
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNewPw1() {
		return newPw1;
	}
	
	public void setNewPw1(String newPw1) {
		this.newPw1 = newPw1;
	}
	
	public String getNewPw2() {
		return newPw2;
	}
	
	public void setNewPw2(String newPw2) {
		this.newPw2 = newPw2;
	}
	
	public String getOldPw() {
		return oldPw;
	}
	
	public void setOldPw(String oldPw) {
		this.oldPw = oldPw;
	}
     }
