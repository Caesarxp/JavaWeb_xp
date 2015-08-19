
  package forms;
   /**
    * 
    * @author Administrator
    * �û表单Bean-完成用户注册信息的收集
    */
   
  public class RegisterFrom {

  private String name;//用户名�û���
  private String password;//密码����
  private String radio;//性别�Ա�
  private String email;//电子邮件�����ʼ�

  public RegisterFrom()
  {}
  
  public String getEmail() {
	return email;
  }
  
  public void setEmail(String email) {
	this.email = email;
  }
  
  public String getName() {
	return name;
  }
  
  public void setName(String name) {
	this.name = name;
  }
  
  public String getPassword() {
	return password;
  }
  
  public void setPassword(String password) {
	this.password = password;
  }
  
  public String getRadio() {
	return radio;
  }
  
  public void setRadio(String radio) {
	this.radio = radio;
   }

  }
