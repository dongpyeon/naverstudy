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
		 // ��й�ȣ �ؽ� ����
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
		// ��й�ȣ �ؽ� ����
        pass = HashService.hashPassword(pass);
        
		boolean bLogin=dao.isLoginCheck(id, pass);
		if(bLogin)
		{
			//������ �����ð�
			session.setMaxInactiveInterval(60*60*6);
			//�α��� ������ ���ǿ� ������ �����
			session.setAttribute("loginok","yes");
			session.setAttribute("id",id);
			
			//���̵� �ش��ϴ� �̸� ���
			String myname=dao.getData(id).getName();
			session.setAttribute("myname", myname);
			//���̵� �ش��ϴ� ���� ���
			String myphoto=dao.getData(id).getPhoto();
			session.setAttribute("myphoto", myphoto);
			
			map.put("success", true);
		}else {
			map.put("success", false); //�α��� ���н�	
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
