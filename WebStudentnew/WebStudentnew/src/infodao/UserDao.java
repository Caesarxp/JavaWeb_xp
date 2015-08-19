
  package infodao;

  import java.util.List;
  import mode.StudentBean;
  import forms.RegisterFrom;

   /**
    * 
    * @author Administrator
    * 用户dao接口
    */
   public interface UserDao {
 
	/**
	 * 用户登录
	 * @param 用户名，密码，身份
	 * @return boolean 
	 */
	public boolean con(String name,String password,int shenfen);
		 
	/**
	 * 用户注册
	 * @param RegisterFrom
	 * @return boolean 
	 */
	public boolean registerByName(RegisterFrom regf);
	 

	/**
	 * 查找所有用户���������û�
	 * @param null
	 * @return list 
	 */
	
	public List findAllUser(String username) ;
	
	
	/**
	 * 删除指定用户
	 * @param String id
	 * @return int rs
	 */
	public int delUserById(String id);
	 
	/**
	 *根据id查找指定用户
	 * @param String id
	 * @return StudentBean
	 */
	public StudentBean findUserById(String id);
	 
	/**
	 *根据对用户的数据进行编辑
	 * @param RegisterFrom,String id
	 * @return boolean
	 */
	public boolean modifyUser(StudentBean regf,String id);
	 
	}
