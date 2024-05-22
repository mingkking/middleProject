package controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	// 서버 가동 시 메인페이지 화면 이동
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	// 메인페이지에서 소개 탭 눌렀을 때 화면 이동
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
}
