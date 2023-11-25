package study.day1109.mvc1;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //자동으로 설정파일에 bean 이 등록된다
public class TestController {
	
	//@RequestMapping("/")
	@GetMapping("/") //스프링 버전 5부터 가능한 어노테이션
	public String home(Model model) //기본이 GET방식 : 초기버전부터 모두 가능한 어노테이션
	
	{
		model.addAttribute("message","Have a Good Time!!!!!!!!");
		model.addAttribute("today", new Date());
		return "result1";
	}
	
	//@GetMapping("/shop/list") //shop/list.*
	//@GetMapping("/shop/list.do") //shop/do 만 호출 가능*
	@GetMapping("/shop/{path1}")
	public String go(Model model,@PathVariable("path1") String p1)
	{	
		
		model.addAttribute("path", "/shop/"+p1);
		return "list";
	}
	
	//@GetMapping("/board/update")
	@GetMapping({"/board/update","/stu/form/test1"}) //두개의 매핑이 같은 곳으로 포워드한다
	public ModelAndView hello(HttpServletRequest request)
	{
		//프로젝트까지의 경로를 얻는다
		String root = request.getContextPath();
		System.out.println(root);
		
		ModelAndView mview=new ModelAndView();
		mview.addObject("message", "매핑주소로 사진을 나타내보자");
		mview.addObject("root", root);
		mview.setViewName("result2");
		return mview;
	}
}
