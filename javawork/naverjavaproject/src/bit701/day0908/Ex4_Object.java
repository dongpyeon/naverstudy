package bit701.day0908;

public class Ex4_Object {
	//인스턴스 멤버변수
	private int score;
	//클래스 멤버변수
	static public String message;
	
	//인스턴스 멤버 메서드
	//score 에 값을 넣는 메서드(setter method)
	public void setScore(int score)
	{
		//멤버변수 score 에 인자로 받은 score를 전달
		//매개변수 명이 멤버변수 명이랑 같을 경우 멤버 변수 앞에
		//this 를 붙인다
		this.score=score;
	}
	//점수를 반환하는 getter method
	public int getScore()
	{
		return score; //this.score 에서 this가 생략 가능
	}
	//static 메서드는 static 멤버변수만 접근가능
	public static void setMessage(String message)
	{
		Ex4_Object.message=message;
	}
	
	public static void main(String[] args) {
		// TODO
		//main 메서드는 static 이므로 new로 생성을 해야 멤버 접근이 가능하다
		//단 static 은 호출 가능
		
		Ex4_Object.setMessage("Hello World!!");
		
		System.out.println(Ex4_Object.message);
		
		Ex4_Object ex4=new Ex4_Object();
		ex4.setScore(89);
		System.out.println("점수"+ex4.getScore());
		
	}
}
