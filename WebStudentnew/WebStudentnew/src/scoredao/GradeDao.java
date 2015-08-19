
  package scoredao;

  import java.util.List;
  import mode.GradeBean;
  import forms.GradeFrom;
   
 
  /**
   * 
   * @author Administrator
   * 成绩持久层接口
   */
   public interface GradeDao {
	   
	     
	   /**
	    * 查找所有学生的成绩
	    * @param：username
	    * @return list
	    * 
	    */
       public List findAllGread(String username);
        
     
       /**
          *查找所有学生id ���������û� 
		  * @param null
		  * @return List 
        */
		public List findAllStudentId();
        
		/**
          * 查找所有课程id ���������û� 
		  * @param null
		  * @return List 
        */
	    public List findAllClassId();
	    
	    /**
          * 插入学生成绩
		  * @param 封装成绩的表单bean
		  * @return null 
       */
	    public void addGrade(GradeFrom gradeFrom);
	     
	    /**
          * 通过id查找成绩 ���������û� 
		  * @param 成绩标识
		  * @return GradeBean
         */
	    public GradeBean findGradeById(int id);
         
	    /**
         * 通过id更新学生成绩 ���������û� 
		  * @param 成绩标识、学生成绩
		  * @return null
        */
	    public void updateGrade(int id,String grade);
         
	    /**
         * 通过id删除学生成绩 ���������û� 
		  * @param 成绩标识 
		  * @return null
        */
	     public void StudentGradeDel(int id);
         
	        
     }