
   package forms;

   import java.text.SimpleDateFormat;
   import java.util.Date;
  
   /**
    * 
    * @author Administrator
    * 表单Bean-收集添加通知的数据
    */
   public class NoticeForm {
    private int id;
	private String title;//通告标题
    private String text;//通告的正文内容
    private String date;//发布通告的时间
     
	public NoticeForm()
	{}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
   }
