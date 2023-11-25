package basic.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "screen/test";
	}
	
	@GetMapping("/site")
	public String site() {
		return "site/first";
	}
	
	@GetMapping("/myhome")
	public String myhome() {
		return "views/home";
	}
	
	@GetMapping("board")
	public String board() {
		return "/board/boardlist";
	}
}
