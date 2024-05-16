package vo.question;

public class QAnswerVO {
	
	private Integer qNo;
	private String qATitle;
	private String qAContent;
	private String qARegdate;
	
	public Integer getqNo() {
		return qNo;
	}
	public void setqNo(Integer qNo) {
		this.qNo = qNo;
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
		return "QAnswerVO [qNo=" + qNo + ", qATitle=" + qATitle + ", qAContent=" + qAContent + ", qARegdate="
				+ qARegdate + "]";
	}
	
	
}
