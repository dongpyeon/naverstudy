package bit701.day0908;

public class Ex3_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체 배열을 이용해서 데이타를 출력해보자
		Bitcamp []bit=new Bitcamp[3];
		//배열 갯수만큼Bitcamp 객체를 생성
		for(int i=0; i<bit.length;i++)
		{
			bit[i]=new Bitcamp();
		}
		
		
		//0번 데이타
		bit[0].name="캔디";
		bit[0].address="대구";
		
		//1번 데이타
		bit[1].name="안쏘니";
		bit[2].address="부산";
		
		//2번 데이타
		bit[2].name="테리우스";
		bit[2].address="부산";
		
		//출력 #1
		for(int i=0; i<bit.length; i++)
		{
		
		}
		
		

		
	}

}
