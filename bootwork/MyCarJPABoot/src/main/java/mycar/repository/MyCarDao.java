package mycar.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;



@Repository
@AllArgsConstructor
public class MyCarDao {
	MyCarDaoInter daoInter;
	
	//전체 개수 구하기
	public Long getTotalCount() {
		return daoInter.count(); //
	}
	
	//db저장
	public void insertMyCar(MyCarDto dto)
	{
		daoInter.save(dto); //save는 dto에 num값이 포함되어 있으면 update, 없으면 insert를 수행함
	}
	
	//전체출력
	public List<MyCarDto> getAllCars()
	{
		return daoInter.findAll(); //전체 데이타 반환
		//return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice")); //가격이 비싼거 부터 출력
		
	}
	
	//페이지출력
	public Page<MyCarDto> getAllCars(Pageable pageable)
	{
		return daoInter.findAll(pageable); //페이지에 필요한 만큼 데이터 반환
		
	}
	
	//num 에 해당하는 dto 반환
	public MyCarDto getData (Long num)
	{
		return daoInter.getReferenceById(num);
	}
	
	//delete
	public void deleteMyCar(Long num)
	{
		daoInter.deleteById(num);
	}
	
	//update
	public void updateMyCar(MyCarDto dto)
	{
		daoInter.save(dto); //dto 에 num이 포함되어있으므로 수정된다
	}
	
	//자동차명,가격,색상만 수정하는 메서드 (사진 수정 안함)
	public void updateMycarNoPhoto(MyCarDto dto)
	{
//		Long num=dto.getNum();
//		String carname=dto.getCarname();
//		String carcolor=dto.getCarcolor();
//		int carprice=dto.getCarprice();
//		
//		daoInter.updateMycarNoPhoto(num, carname, carprice, carcolor);
		
		//dto 로 직접 파라미터를 넘긴경우로 테스트하기
		//사진을 제외한 나머지 컬럼을 모두 수정하기
		daoInter.updateMycarDTONoPhoto(dto);
	}
}
