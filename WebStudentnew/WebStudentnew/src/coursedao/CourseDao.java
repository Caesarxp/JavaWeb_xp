
  package coursedao;

  import java.util.List;
  import mode.ClassBean;

 
   
   /**
    * 
    * @author Administrator
    * 课程dao接口
    */
   public interface CourseDao {
 
	 
   
	/**
	  *查找所有课程 ���������û� 
	  * @param null
	  * @return List 
	  */
	public List findAllCourse();
   
	/**
	  *根据id查找课程 ���������û� 
	  * @param id
	  * @return classBean 
	  */
	public ClassBean findAllCourseById(int id);
	
	/**
	  * 更新课程信息
	  * @param classBean
	  * @return null 
	  */
	  
   public void updateCourse(ClassBean classBean);
   
   
   /**
	 * 删除课程信息
	 * @param id
	 * @return null 
	 */
	public void delCourse(int id);
	
	/**
	 * 添加课程信息
	 * @param classBean
	 * @return null 
	 */
	public void addCourse(ClassBean classBean);
   
   }
