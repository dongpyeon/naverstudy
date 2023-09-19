import java.util.Scanner;

public class subject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money =0, total=0, toggle=0;
		label:
		while(true) {
			System.out.println("=".repeat(40));
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("=".repeat(40));
			
			toggle = sc.nextInt();
			if(toggle <1 || toggle >4) {
				System.out.println("1~4 사잇값을 입력하세요");
				
			}
			switch(toggle) {
			case 1:
				System.out.println("얼마를 예금하시겠습니까?");
				int m=0;
				m=sc.nextInt();
				money+=m;
				System.out.println("입금되었습니다.");
				break;
				
			case 2:
				System.out.println("얼마를 출금하시겠습니까?");
				int culgum = 0;
				culgum = sc.nextInt();
				
				if(culgum>money) {
					System.out.println("잔고에 있는 돈이 모자랍니다.");
					break;
				}
				
				money-=culgum;
				System.out.println("출금되었습니다.");
				break;	
				
			case 3:
				System.out.printf("현재 잔고 : %d \n",money);
				break;	
				
			case 4:
				System.out.println("ㅂㅂ");
				break label;	
			}	
		}
		

		
	}
}

