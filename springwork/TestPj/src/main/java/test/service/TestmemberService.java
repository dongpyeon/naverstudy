package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.TestmemberDao;
import test.dto.TestmemberDto;

@Service
public class TestmemberService {
	@Autowired
	private TestmemberDao testmemberdao;
	
	public TestmemberDto getMemberByUsername(String username)
	{
		
	}
}
