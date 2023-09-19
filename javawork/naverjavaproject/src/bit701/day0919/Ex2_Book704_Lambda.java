package bit701.day0919;
//리턴타입이 있는 람다식

interface CalcInter{
	double calc(double x, double y);
}

class Person{
	public void action(CalcInter cal) {
		double result=cal.calc(10, 4);
		System.out.println("결과 ="+result);
	}
}
public class Ex2_Book704_Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		//실행문이 두개인 경우
		person.action((x,y) ->{
			double result=x+y;
			return result;
			
		});
	}

}
