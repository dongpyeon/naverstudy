package day1109.test6.anno;

import org.springframework.stereotype.Component;

@Component
public class AnnoKoreaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "한쿸 타이어에요 어노 ㅋㅋ";
	}

}
