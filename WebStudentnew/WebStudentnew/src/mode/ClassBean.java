
  package mode;
  
  /**
   * 
   * @author Administrator
   * 结果Bean-完成课程信息的收集
   */
  public class ClassBean {
   private int id;//标识
   private String className;//课程名称
   private String teacher;//任课教师
   private String score;//课程学分
 
   public ClassBean()
   {}
   
   public String getClassName() {
	return className;
   }
   
   public void setClassName(String className) {
	this.className = className;
   }

   public int getId() {
	return id;
   }
   
   public void setId(int id) {
	this.id = id;
   }

   public String getScore() {
	return score;
   }

   public void setScore(String score) {
	this.score = score;
   }

   public String getTeacher() {
	return teacher;
   }

  public void setTeacher(String teacher) {
	this.teacher = teacher;
  }
  
  }
