package bit701.day0908;

public class Ex5_SawonCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sa = new Sawon();
		sa.setSawonNo("bit1234");
		sa.setName("강호동");
		sa.setAge(35);
		
		System.out.println("** 신입사원#1 정보**");
		Ex5_SawonCall.printSawon(sa);
		
		Sawon sa2=new Sawon();
		sa2.setSawonNo("bit9999");
		sa2.setName("김나나");
		sa2.setAge(38);
		
		Ex5_SawonCall.printSawon(sa2);
		
	}
	public static void printSawon(Sawon s)
	{
		System.out.println("사원 번호 :"+s.getSawonNo());
		System.out.println("사원명 : "+s.getName());
		System.out.println("나이 :"+s.getAge());
		System.out.println();
	}

}
