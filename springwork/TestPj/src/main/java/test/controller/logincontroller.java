package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import test.dto.TestmemberDto;

@Controller
public class logincontroller {
	@GetMapping("/login")
	public String login() {
		
		
		return "/login/loginmain";
	}
}
