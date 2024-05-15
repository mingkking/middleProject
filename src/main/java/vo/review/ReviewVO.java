package vo.review;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.util.StringUtils;
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
		/*
		 * this.rPicture = rPicture;
		 * 
		 * // 업로드 파일이 있는 경우 if( !rPicture.isEmpty()) { this.r_fname =
		 * rPicture.getOriginalFilename(); this.r_fsize = rPicture.getSize();
		 * 
		 * // 실제 저장된 파일명 만들기 UUID uuid = UUID.randomUUID(); this.r_frealname =
		 * uuid.toString() + "_" + r_fname;
		 * 
		 * // 실제파일 저장 // 추후에 웹서버 경로를 찾아서 수정 File f = new File(
		 * "C:\\works\\stsWorks\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\middleprojects\\resources\\reviewUpload\\"
		 * + r_frealname); // 본인 컴퓨터 저장 //File f = new File(
		 * "C:\\Users\\peoplecom\\git\\middleProject\\src\\main\\webapp\\resources\\reviewUpload\\"
		 * + r_frealname);
		 * 
		 * try { rPicture.transferTo(f); } catch (IllegalStateException e) {
		 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * }
		 */
		
		this.rPicture = rPicture;

	    // 업로드 파일이 있는 경우
	    if (!rPicture.isEmpty()) {
	        // 파일명 검사 및 중복 방지를 위한 UUID 생성
	        String originalFilename = StringUtils.cleanPath(rPicture.getOriginalFilename());
	        String uuidFilename = UUID.randomUUID().toString() + "_" + originalFilename;

	        try {
	            // 파일 저장 경로 설정
	            //String uploadDir = "C:\\works\\stsWorks\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\middleprojects\\resources\\reviewUpload"; // 실제 저장 경로에 맞게 수정 필요
	            String uploadDir = "C:\\Users\\peoplecom\\git\\middleProject\\src\\main\\webapp\\resources\\reviewUpload"; // 실제 저장 경로에 맞게 수정 필요
	            Path uploadPath = Paths.get(uploadDir);

	            // 디렉토리가 존재하지 않으면 생성
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }

	            // 파일 저장 경로에 파일 저장
	            Path filePath = uploadPath.resolve(uuidFilename);
	            Files.copy(rPicture.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	            // 파일 정보 설정
	            this.r_fname = originalFilename;
	            this.r_fsize = rPicture.getSize();
	            this.r_frealname = uuidFilename;

	        } catch (IOException e) {
	            e.printStackTrace();
	            // 파일 저장 실패 시 예외 처리
	        }
	    }
	}
	
	
	@Override
	public String toString() {
		return "ReviewVO [rNo=" + rNo + ", id=" + id + ", pNo=" + pNo + ", rTitle=" + rTitle + ", rContent=" + rContent
				+ ", rRegDate=" + rRegDate + ", rPicture=" + rPicture + ", r_fname=" + r_fname + ", r_frealname="
				+ r_frealname + ", r_fsize=" + r_fsize + "]";
	}
	
	
}
