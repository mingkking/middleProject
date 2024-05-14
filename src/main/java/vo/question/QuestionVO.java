package vo.question;

public class QuestionVO {
	
	private Integer qNo;
	private String id;
	private String qTitle;
	private String qContent;
	private String qPassword;
	private String qRegdate;
	private String qStatus;
	
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
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqPassword() {
		return qPassword;
	}
	public void setqPassword(String qPassword) {
		this.qPassword = qPassword;
	}
	public String getqRegdate() {
		return qRegdate;
	}
	public void setqRegdate(String qRegdate) {
		this.qRegdate = qRegdate;
	}
	public String getqStatus() {
		return qStatus;
	}
	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}
	
	@Override
	public String toString() {
		return "QuestionVO [qNo=" + qNo + ", id=" + id + ", qTitle=" + qTitle + ", qContent=" + qContent
				+ ", qPassword=" + qPassword + ", qRegdate=" + qRegdate + ", qStatus=" + qStatus + "]";
	}
	
	
}
