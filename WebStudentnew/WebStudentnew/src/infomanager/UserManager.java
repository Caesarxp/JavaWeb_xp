 
  package infomanager;

  import infodao.UserDao;
  import infodao.UserDao4MySqlImpl;
  import java.util.List;
  import mode.StudentBean;
  import forms.LoginForm;
import forms.RegisterFrom;

  /**
   * �û���业务类-单例模式����
   * @author Administrator
   *
   */
  public class UserManager {
	 
  static private UserManager instance=null;
 
  private UserManager()
  {}
	 
  static public synchronized UserManager getInstance()
  {
	 if(instance==null)
	 {
		 instance=new UserManager(); 
		 
	 }
     return instance;
  }
 
   /**
	  * 用户登录�û���¼
	  * @param LoginForm
	  * @param boolean 
	  */
	
	public boolean login(LoginForm loginf){
	UserDao intsl=new UserDao4MySqlImpl();
	 boolean flag=intsl.con(loginf.getUsername(), loginf.getPassword(),loginf.getShenfen());
	return flag;
	}
	
	/**
	 * �用户注册��
	 * @param RegisterFrom
	 * @param boolean 
	 */
	public boolean Register(RegisterFrom regf)
	{   
		UserDao intsl=new UserDao4MySqlImpl();
		boolean flag=intsl.registerByName(regf);
		return flag;
	}
    
	 /**
	  *查找所有用户 ���������û� 
	  * @param null
	  * @param List 
	  */
	public List findAllUse(String username)
    { 
	  UserDao dao=new UserDao4MySqlImpl();
      List AllUser=dao.findAllUser(username);
      return AllUser;
    }
	
	/**
	 *删除指定用户
	 * @param id
	 * @param int 
	 */
	public int delUserById(String id)  
	{
		UserDao intsl=new UserDao4MySqlImpl();
		int flag=intsl.delUserById(id);
		return flag;
	}
	
	public StudentBean findUserById(String id)  
	{
		UserDao intsl=new UserDao4MySqlImpl();
		StudentBean bean=intsl.findUserById(id);
		return bean;
	}
	
	/**
	 *根据对用户的数据进行编辑��ݶ��û�����ݽ��б༭
	 * @param RegisterFrom,String id
	 * @return boolean
	 */
	public boolean modifyUser(StudentBean regf,String id)
	{   
		UserDao intsl=new UserDao4MySqlImpl();
		boolean flag=intsl.modifyUser(regf,id);
		return flag;
	}
   }
