   
  package forms;
    /**
     * 
     * @author Administrator
     * 表单Bean-完成用户登录信息的收集
     */
      
   public class LoginForm {

   private String username ;//用户名
   private String password;//密码����
   private int shenfen;//身份�û����

   public LoginForm()
   {}
  
   public String getPassword() {
	return password;
   }
   
   public void setPassword(String password) {
	this.password = password;
   }

   public int getShenfen() {
	return shenfen;
   }
   
   public void setShenfen(int shenfen) {
	this.shenfen = shenfen;
   }
   
   public String getUsername() {
	return username;
   }
   
   public void setUsername(String username) {
	this.username = username;
   }
  
   }
