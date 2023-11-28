package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import test.dto.TestmemberDto;

@Controller
public class mypagecontroller {
	
	@GetMapping("/mypage")
	public String mypage(Model model, TestmemberDto dto) {
		String username = dto.getName();
		
		
		TestmemberDto member =
		
		return "mypage/mypageform";
		
		
		
		
		
	}
}
