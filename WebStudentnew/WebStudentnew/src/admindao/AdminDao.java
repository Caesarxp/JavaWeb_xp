 
   package admindao;

   
   import java.sql.SQLException;
   import java.util.ArrayList;
   import java.util.List;
   import forms.AdminPasswordForm;
   import mode.UseBean;
   import util.DB;
  
  
  /**
   * 
   * @author Administrator
   * 管理员接口
   */

   public interface  AdminDao {
	   
	    
	    
	   
	   List list = new ArrayList();
	    
	   
	  
	  /**
		  *查找所有管理员信息 ���������û� 
		  * @param null
		  * @return List 
		  */
	  public List findAllAdmin();
     
	
	     /**
		  *取得管理员信息 ���������û� 
		  * @param 管理员姓名
		  * @return UseBean 
		  */
	  public UseBean findAdminPsaaword (String adminName);
		 
   
	     /**
		  *修改管理员密码 ���������û� 
		  * @param adminpasswordForm
		  * @return null 
		  */
	   public void updataAdminPasswordFinsh(AdminPasswordForm adminpasswordForm);
        
      }
