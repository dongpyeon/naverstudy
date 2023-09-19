import java.util.Scanner;

public class Ju_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		String year,month,day,num,sex;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요");
		System.out.println("xxxxxx-xxxxxxx");
		
		while(true) {
			num = sc.nextLine();
			if(num.equalsIgnoreCase("q")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
	
			year=num.substring(0,2);
			month=num.substring(2,4);
			day=num.substring(4,6);
			
			System.out.printf("%s년 %s월 %s일생",year,month,day);
			
			sex=num.substring(7,7);
			if(sex.equals("1"))
				System.out.println("내국인 입니다");
			else
				System.out.println("외국인 입니다");
		}

		
		
		
	}

}
