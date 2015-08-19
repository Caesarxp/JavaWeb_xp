
  package forms;

  /**
   * 
   * @author Administrator
   * 收集学生成绩信息
   */
  public class GradeFrom{ 
   
   private int studentId;//学生标识
   private int classId;//课程标识
   private String grade;//学生成绩
   
   public GradeFrom()
   {}
   
   public int getClassId() {
	 return classId;
   }
   
   public void setClassId(int classId) {
	 this.classId = classId;
   }
   
   public String getGrade() {
	return grade;
   }
   
   public void setGrade(String grade) {
	this.grade = grade;
    }
   
   public int getStudentId() {
	return studentId;
   }
   
   public void setStudentId(int studentId) {
	this.studentId = studentId;
   }
 
  
  }
