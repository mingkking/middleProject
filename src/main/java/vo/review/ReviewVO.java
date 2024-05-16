package vo.review;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVO {
	private int rNo;
	private String id;
	private int pNo;
	private String rTitle;
	private String rContent;
	private String rRegDate;
	private String r_fname;
	private String r_frealname;
	private long r_fsize;
	private MultipartFile rPicture;
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrRegDate() {
		return rRegDate;
	}
	public void setrRegDate(String rRegDate) {
		this.rRegDate = rRegDate;
	}
	public String getR_fname() {
		return r_fname;
	}
	public void setR_fname(String r_fname) {
		this.r_fname = r_fname;
	}
	public String getR_frealname() {
		return r_frealname;
	}
	public void setR_frealname(String r_frealname) {
		this.r_frealname = r_frealname;
	}
	public long getR_fsize() {
		return r_fsize;
	}
	public void setR_fsize(long r_fsize) {
		this.r_fsize = r_fsize;
	}
	public MultipartFile getrPicture() {
		return rPicture;
	}
	public void setrPicture(MultipartFile rPicture) {
		this.rPicture = rPicture;
		
		// 업로드 파일이 있는 경우
		if( !rPicture.isEmpty()) {
			this.r_fname = rPicture.getOriginalFilename();
			this.r_fsize = rPicture.getSize();
			
			// 실제 저장된 파일명 만들기
			UUID uuid = UUID.randomUUID();
			this.r_frealname = uuid.toString() + "_" + r_fname;
			
			// 실제파일 저장
			// 추후에 웹서버 경로를 찾아서 수정
			File f = new File("C:\\Users\\ict03_029\\git\\middleProject\\src\\main\\webapp\\resources\\reviewUpload\\" + r_frealname);
			
			try {
				rPicture.transferTo(f);
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public String toString() {
		return "ReviewVO [rNo=" + rNo + ", id=" + id + ", pNo=" + pNo + ", rTitle=" + rTitle + ", rContent=" + rContent
				+ ", rRegDate=" + rRegDate + ", r_fname=" + r_fname + ", r_frealname=" + r_frealname + ", r_fsize="
				+ r_fsize + ", rPicture=" + rPicture + "]";
	}
	
	
}
