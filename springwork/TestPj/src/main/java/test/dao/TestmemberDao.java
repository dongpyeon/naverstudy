package test.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.dto.TestmemberDto;

@Repository
public class TestmemberDao {
	@Autowired
	private SqlSession session;
	private String nameSpace="test.dao.TestmemberDao.";
	
	public void insertMember(TestmemberDto dto)
	{
		session.insert(nameSpace+"insertMember",dto);
	}
	
	public boolean isLoginCheck(String id,String pass)
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		
		int n=session.selectOne(nameSpace+"loginCheck",map);
		return n==0?false:true;
	}
	
	public TestmemberDto getData(String myid)
	{
		return session.selectOne(nameSpace+"selectDataById",myid);
	}
	
	public TestmemberDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectDataByNum",num);
	}
	
	
	
}
