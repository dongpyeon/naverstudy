package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("mycar2") // id는 mycar2가 된다.
@AllArgsConstructor
public class AnnoCar2 {
	
 	AnnoKoreaTire koreaTire;
 	AnnoCanadaTire canadaTire;
 	public void myCarInfo()
	{
		System.out.println("내 차의 타이어는 "+koreaTire.getTireName()+"임니다 ㅋㅋ");
		System.out.println("겨울용 타이어는 "+canadaTire.getTireName()+"임니다 ㅋㅋ");
	}

}
