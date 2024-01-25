package data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import data.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int getTotalCount(String search);
	public List<BoardDto> getAlldatas(HashMap<String, Object> map);
	public void insertBoard(BoardDto dto);
	public BoardDto getboarddetail(int num);
	@Update("update simpleboard set readcount=readcount+1 where num=#{num}")
	public void updateReadcount(int num);
}
