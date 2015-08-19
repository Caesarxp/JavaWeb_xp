
   package mode;
  
  /**
   * 
   * @author Administrator
   * 结果Bean-完成学生信息的收集
   */
   public class StudentBean {
	
	String name;//姓名
	String password;//密码
	int id;//标识
	String sex;//性别
	String email;//电子邮件

	public StudentBean()
	{}
	
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
  }
