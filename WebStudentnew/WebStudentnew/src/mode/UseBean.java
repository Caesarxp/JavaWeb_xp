   
   package mode;
   /**
    * 
    * @author Administrator
    *
    */
   public class UseBean {
  
   private int id;//管理员id
   private String useName;//管理员姓名
   private String password;//管理员密码
   
   public UseBean()
   {}
   
   public int getId() {
	return id;
    }
    
   public void setId(int id) {
	this.id = id;
   }
   
    public String getPassword() {
	return password;
   }
    
   public void setPassword(String password) {
	this.password = password;
   }
   
   public String getUseName() {
	return useName;
   }
  
   public void setUseName(String useName) {
	this.useName = useName;
   }
   
   
   }
