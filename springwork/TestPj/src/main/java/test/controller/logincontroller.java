package test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import test.dao.TestmemberDao;
import test.dto.TestmemberDto;
import test.service.HashService;

@Controller
public class logincontroller {
	@Autowired
	TestmemberDao dao;
	
	@GetMapping("/signup")
	public String sign() {
		
		
		return "/login/signupform";
	}
	
	@PostMapping("/login/signup")
	public String signin(@ModelAttribute TestmemberDto dto)
	{
		 // 비밀번호 해싱 적용
        HashService.hashAndSetPassword(dto, dto.getPass());

        dao.insertMember(dto);
		
		return "/screen/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login/loginform";
	}
	
	@PostMapping("/login/check")
	public String check(@RequestParam String id,@RequestParam String pass, HttpSession session) 
	{
		Map<String, Object> map=new HashMap<String, Object>();
		// 비밀번호 해싱 적용
        pass = HashService.hashPassword(pass);
        
		boolean bLogin=dao.isLoginCheck(id, pass);
		if(bLogin)
		{
			//ㅅ세션 유지시간
			session.setMaxInactiveInterval(60*60*6);
			//로그인 성공시 세션에 저장할 내용들
			session.setAttribute("loginok","yes");
			session.setAttribute("id",id);
			
			//아이디에 해당하는 이름 얻기
			String myname=dao.getData(id).getName();
			session.setAttribute("myname", myname);
			//아이디에 해당하는 사진 얻기
			String myphoto=dao.getData(id).getPhoto();
			session.setAttribute("myphoto", myphoto);
			
			map.put("success", true);
		}else {
			map.put("success", false); //로그인 실패시	
		}
		return 	"redirect:../";
	}
	@GetMapping("/login/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("loginok");
		return 	"redirect:../";
	}
	@GetMapping("/login/findpass")
	public String findpass() 
	{
		return "/login/findform";
	}
	
}
