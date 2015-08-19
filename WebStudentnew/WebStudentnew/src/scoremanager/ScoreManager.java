
  package scoremanager;

  import java.util.List;
  import mode.GradeBean;
  import forms.GradeFrom;
  import scoredao.GradeDao;
  import scoredao.GradeDaoImpl;

  /**
   * �û���成绩处理业务类-单例模式����
   * @author Administrator
   *
   */

   public class ScoreManager {
  
	  static private ScoreManager instance=null;
	  
	  private ScoreManager()
	  {}
		 
	  static public synchronized ScoreManager  getInstance()
	  {
		 if(instance==null)
		 {
			 instance=new ScoreManager(); 
			 
		 }
	     return instance;
	  }
  
	    /**
		  *查找所有用户 ���������û� 
		  * @param username
		  * @param List 
		  */
		public List findAllScore(String username)
	    {
		  GradeDao dao =new GradeDaoImpl();
	      List allGread=dao.findAllGread(username);
	      return allGread;
	    }
       
		/**
         *查找所有学生id ���������û� 
		  * @param null
		  * @param List 
         */
		public List findAllStudentId()
        {   GradeDao dao =new GradeDaoImpl();
            List allStudentId=dao.findAllStudentId();
            return allStudentId;
        }
		
		/**
         * 查找所有课程id ���������û� 
		  * @param null
		  * @param List 
         */
	    public List findAllClassId()
	    {   GradeDao dao =new GradeDaoImpl();
	        List allClassId=dao.findAllClassId();
        return allClassId;
        }
        
	    /**
         * 插入学生成绩
		  * @param 封装成绩的表单bean
		  * @return null 
      */
	    public void addGrade(GradeFrom gradeFrom)
        {   GradeDao dao =new GradeDaoImpl();
            dao.addGrade(gradeFrom);
        }
       
        /**
          * 通过id查找成绩 ���������û� 
		  * @param 成绩标识
		  * @return GradeBean
         */
        public GradeBean findGradeById(int id)
        {
        	GradeBean gradeBean=null;
        	GradeDao dao=new GradeDaoImpl();
        	gradeBean=dao.findGradeById(id);
        	return gradeBean;
        } 
        
        /**
         * 通过id更新学生成绩 ���������û� 
		  * @param 成绩标识、学生成绩
		  * @return null
        */
        public void updateGrade(int id,String grade)
        { GradeDao dao=new GradeDaoImpl();
          dao.updateGrade(id, grade);
        }
        
        /**
         * 通过id删除学生成绩 ���������û� 
		  * @param 成绩标识 
		  * @return null
        */
        public void StudentGradeDel(int id)
        { GradeDao dao=new GradeDaoImpl();
          dao.StudentGradeDel(id);
        }
   
   }
   
