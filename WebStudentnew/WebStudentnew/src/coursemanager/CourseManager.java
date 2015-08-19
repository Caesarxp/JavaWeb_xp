
   package coursemanager;

   import java.util.ArrayList;
   import java.util.List;
   import mode.ClassBean;
   import coursedao.CourseDao;
   import coursedao.CourseDao4MySqlImpl;
    
    

    public class CourseManager {
	  /**
	   * �û���tgg课程管理业务类-单例模式����
	   * @author Administrator
	   * 
	   */

	  static private CourseManager instance=null;
		  
		  private CourseManager()
		  {}
			 
		  static public synchronized CourseManager getInstance()
		  {
			 if(instance==null)
			 {
				 instance=new CourseManager(); 
				 
			 }
		     return instance;
		  }
		  
		   
			/**
			  *查找所有课程 ���������û� 
			  * @param null
			  * @return List 
			  */
			public List findAllCourse()
		    {
			   CourseDao dao=new CourseDao4MySqlImpl();
		       List allCourse=dao.findAllCourse();
		       return allCourse;
		    }
			
			/**
			  *根据id查找课程 ���������û� 
			  * @param id
			  * @return classBean 
			  */
			public ClassBean findAllCourseById(int id)
			{  CourseDao dao=new CourseDao4MySqlImpl();
		       ClassBean Course=dao.findAllCourseById(id);
		       return Course;
				
			}
			
			/**
			 * 更新课程信息
			 * @param classBean
			 * @return null 
			 */
			public void updateCourse(ClassBean classBean)
			{
				CourseDao dao=new CourseDao4MySqlImpl();
				dao.updateCourse(classBean);
			}
			
			/**
			 * 删除课程信息
			 * @param id
			 * @return null 
			 */
			public void delCourse(int id) 
			{
				CourseDao dao=new CourseDao4MySqlImpl();
			    dao.delCourse(id);
			    }
    
			/**
			 * 添加课程信息
			 * @param classBean
			 * @return null 
			 */
			public void addCourse(ClassBean classBean)
			{
				CourseDao dao=new CourseDao4MySqlImpl();
				dao.addCourse(classBean);
			}
    
    }	 
