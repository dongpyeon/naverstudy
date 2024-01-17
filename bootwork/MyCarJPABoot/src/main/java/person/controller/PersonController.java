package person.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import person.data.PersonDao;
import person.data.PersonDto;

@RestController //responsbody 인가 안써도 됨 머 리액트랑연동하면 다 비동기라 그런가?
@RequiredArgsConstructor
public class PersonController {
	private final PersonDao personDao;
	
	//추가
	@PostMapping("/person/add")
	public void insert(@RequestBody PersonDto dto) //RequestBody 꼭 써야함 생략하면 model attribute로 인식함
	{
		System.out.println("add>>"+dto);
		//db insert
		personDao.insertPerson(dto);
	}
	
	//출력
	@GetMapping("/person/list")
	public List<PersonDto> list()
	{
		System.out.println("list>>");
		return personDao.getAllpersons();
	}
	
	//삭제
	@DeleteMapping("/person/delete")
	public void delete(@RequestParam("pnum") int pnum)
	{
		System.out.println("delete>>"+pnum);
		personDao.deletePerson(pnum);
	}
}
