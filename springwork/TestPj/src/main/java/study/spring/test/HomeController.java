package study.spring.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "screen/main";
	}
	
	@GetMapping("/dig/dag")
	public String dig() {
		return "screen/sub";
	}
}
