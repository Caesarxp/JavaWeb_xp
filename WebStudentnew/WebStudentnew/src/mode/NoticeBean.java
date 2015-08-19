
  package mode;
  /**
   * 
   * @author Administrator
   * 结果BEAN-封装通告表中的数据
   */
  public class NoticeBean {
	    private int id;
		private String text;
		private String head;
		private String time;
		
		public NoticeBean()
		{}
		
		public String getHead() {
			return head;
		}
		
		public void setHead(String head) {
			this.head = head;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getText() {
			return text;
		}
		
		public void setText(String text) {
			this.text = text;
		}
		
		public String getTime() {
			return time;
		}
		
		public void setTime(String time) {
			this.time = time;
		}
  
    }
