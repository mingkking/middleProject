package vo.question;

public class QAnswerVO {
	
	private Integer qANo;
	private Integer qNo;
	private String id;
	private String qATitle;
	private String qAContent;
	private String qARegdate;
	
	
	public Integer getqANo() {
		return qANo;
	}
	public void setqANo(Integer qANo) {
		this.qANo = qANo;
	}
	public Integer getqNo() {
		return qNo;
	}
	public void setqNo(Integer qNo) {
		this.qNo = qNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getqATitle() {
		return qATitle;
	}
	public void setqATitle(String qATitle) {
		this.qATitle = qATitle;
	}
	public String getqAContent() {
		return qAContent;
	}
	public void setqAContent(String qAContent) {
		this.qAContent = qAContent;
	}
	public String getqARegdate() {
		return qARegdate;
	}
	public void setqARegdate(String qARegdate) {
		this.qARegdate = qARegdate;
	}
	
	@Override
	public String toString() {
		return "QAnswerVO [qANo=" + qANo + ", qNo=" + qNo + ", id=" + id + ", qATitle=" + qATitle + ", qAContent="
				+ qAContent + ", qARegdate=" + qARegdate + "]";
	}
	
	
}
