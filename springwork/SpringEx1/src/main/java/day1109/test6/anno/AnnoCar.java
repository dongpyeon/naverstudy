package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component //id : annoCar�� �ǰ��� (Ŭ������ ù���� �ҹ��ڷ� �Ǵϱ�)
@Component("mycar") // id�� mycar�� �ȴ�.
public class AnnoCar {
	
	//@Autowired //�ڵ� ���� - ���� �߻� : ��Ī ������ Ŭ������ 2���̹Ƿ� ������ �߻�
	//�������̽��� ������ Ŭ������ �������� ��� ��Ȯ�ϰ� Ŭ���������� �����ϸ� �ȴ�.   ? 
	//�����ϱ� ������ �˾Ƽ� �ڵ����Եȴ�.
 	//@Autowired
	//AnnoCanadaTire annoTire;
	//AnnoKoreaTire annoTire;
	
 	//@Resource�� �������̽��� ������ Ŭ������ �������� ��� �� ��� �����ش� (������ ������ ��)
 	@Resource(name="annoCanadaTire")
 	AnnoTire annoTire;
 	public void myCarInfo()
	{
		System.out.println("�� ���� Ÿ�̾�� "+annoTire.getTireName()+"�Ӵϴ� ����");
	}

}
