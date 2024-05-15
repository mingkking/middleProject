package useful.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

	public void sendMail(String emailAddr) {

		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");     // gmail,naver은 true 고정
		p.put("mail.smtp.host", "smtp.naver.com");      // smtp 서버 주소
		p.put("mail.smtp.auth","true");                 // gmail,navar은 true 고정
		p.put("mail.smtp.port", "587");                 // 네이버 포트

		Authenticator auth = new MyAuthentication();
		//session 생성 및  MimeMessage생성
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);

		try{
			//편지보낸시간
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress("jumki@naver.com"); //발신자 아이디
			// 이메일 발신자
			msg.setFrom(from);
			// 이메일 수신자
			InternetAddress to = new InternetAddress(emailAddr);
			msg.setRecipient(Message.RecipientType.TO, to);
			// 이메일 제목
			msg.setSubject("메일 전송 테스트", "UTF-8");
			// 이메일 내용
			String message = "당신의 인증번호입니다    ";
			message += getTempPassword();
			
			msg.setText(message, "UTF-8");
			// 이메일 헤더
			msg.setHeader("content-Type", "text/html");
			//메일보내기
			Transport.send(msg, msg.getAllRecipients());

		}catch (AddressException addr_e) {
			addr_e.printStackTrace();
		}catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}catch (Exception msg_e) {
			msg_e.printStackTrace();
		}
	}



	public static String getTempPassword(){
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		String str = "";

		// 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			idx = (int) (charSet.length * Math.random());
			str += charSet[idx];
		}
		return str;
	}

}
