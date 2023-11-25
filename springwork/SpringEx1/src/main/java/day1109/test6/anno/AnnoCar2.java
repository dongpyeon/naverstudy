package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("mycar2") // id�� mycar2�� �ȴ�.
@AllArgsConstructor
public class AnnoCar2 {
	
 	AnnoKoreaTire koreaTire;
 	AnnoCanadaTire canadaTire;
 	public void myCarInfo()
	{
		System.out.println("�� ���� Ÿ�̾�� "+koreaTire.getTireName()+"�Ӵϴ� ����");
		System.out.println("�ܿ�� Ÿ�̾�� "+canadaTire.getTireName()+"�Ӵϴ� ����");
	}

}
