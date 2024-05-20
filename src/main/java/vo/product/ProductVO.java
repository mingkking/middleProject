package vo.product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	
	private Integer pNo;
	private String pName;
	private String pLocation;
	private Integer pPrice;
	
	//*************************************************
	MultipartFile pPicture; // ****** type='file'의 name명과 동일
	
	private String pInfo;
	private String p_fname;		// 파일명
	private String p_frealname; // 저장된 파일이름
	private long p_fsize; // 파일크기 
	
	
	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	public Integer getpPrice() {
		return pPrice;
	}
	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public String getp_fname() {
		return p_fname;
	}
	public void setp_fname(String p_fname) {
		this.p_fname = p_fname;
	}
	public String getp_frealname() {
		return p_frealname;
	}
	public void setp_frealname(String p_frealname) {
		this.p_frealname = p_frealname;
	}
	public long getp_fsize() {
		return p_fsize;
	}
	public void setp_fsize(long p_fsize) {
		this.p_fsize = p_fsize;
	}
	
	// 파일 게터 세터
	public MultipartFile getpPicture() {
		return pPicture;
	}
	public void setpPicture(MultipartFile pPicture) {
		this.pPicture = pPicture;
		
		// 업로드 파일이 있는 경우
		if( !pPicture.isEmpty()) {
			this.p_fname = pPicture.getOriginalFilename();
			this.p_fsize = pPicture.getSize();
			
			// 실제 저장된 파일명 만들기
			UUID uuid = UUID.randomUUID();
			this.p_frealname = uuid.toString() + "_" + p_fname;
			
			// 실제파일 저장
			// 추후에 웹서버 경로를 찾아서 수정
			File f = new File("C:\\Users\\ict03_029\\git\\middleProject\\src\\main\\webapp\\resources\\productUpload\\" + p_frealname);
			try {
				pPicture.transferTo(f);
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [pNo=" + pNo + ", pName=" + pName + ", pLocation=" + pLocation + ", pPicture=" + pPicture + ", pPrice=" + pPrice
				+ ", pInfo=" + pInfo + ", p_fname=" + p_fname + ", p_frealname=" + p_frealname + ", p_fsize=" + p_fsize
				+ "]";
	}
	
	
	
}
