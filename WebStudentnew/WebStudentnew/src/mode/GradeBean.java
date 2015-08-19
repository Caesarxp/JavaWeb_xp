
  package mode;
  /**
   * 
   * @author Administrator
   * 结果Bean-完成学生成绩的收集
   */
  public class GradeBean {
	
	int id;//成绩标识
	String stu_name;//学生姓名
	String class_name;//课程名
	String class_teacher;//教师名
	String class_score;//课程学分
	String stu_grade;//学生成绩
	
	public GradeBean()
	{}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stuName) {
		stu_name = stuName;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String className) {
		class_name = className;
	}
	public String getClass_teacher() {
		return class_teacher;
	}
	public void setClass_teacher(String classTeacher) {
		class_teacher = classTeacher;
	}
	public String getClass_score() {
		return class_score;
	}
	public void setClass_score(String classScore) {
		class_score = classScore;
	}
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stuGrade) {
		stu_grade = stuGrade;
	}
  }
