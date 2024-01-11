package mycar.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;



@Repository
@AllArgsConstructor
public class MyCarCommentDao {
	
	private MyCarCommentDaointer commentDaoInter;
	
	//댓글 저장 
	public void inertComment(MyCarCommentDto dto)
	{
		commentDaoInter.save(dto);
	}
	
	//댓글 목록
	public List<MyCarCommentDto> getMyCarCommentList(Long num)
	{
		return commentDaoInter.getMyCarCommentList(num);
	}
}
