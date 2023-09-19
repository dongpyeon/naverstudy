package bit701.day0911;

import java.util.Scanner;

public class Book_Bank2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Account2 []ac = new Account2[10];
		int count =0;
		
		END:
		while(true) {
			int choice;
			System.out.println("선택>");
			choice =Integer.parseInt(sc.nextLine());
			switch(choice) {
				case 1:
					if(count>2) {
						System.out.println("계좌생성 불가능");
						break;
					}
					System.out.println("------------\n계좌생성\n------------");
					System.out.println("계좌번호:");
					String accountnum = sc.nextLine();
					System.out.println("계좌주:");
					String accountname=sc.nextLine();
					System.out.println("초기입금액:");
					int money = Integer.parseInt(sc.nextLine());
					System.out.println("결과: 계좌가 생성되었습니다.");
					ac[count]=new Account2(accountnum, accountname, money);
					count++;
					break;
					
				case 2:
					System.out.println("------------\n계좌목록\n------------");
					for(int i=0; i<count; i++) {
						ac[i].viewList();
					}
					break;
					
				case 3:
					System.out.println("------------\n계좌목록\n------------");
					System.out.println("계좌번호:");
					String findnum=sc.nextLine();
					for(int i=0; i<count; i++) {
						if(ac[i].chenckno(findnum))
							System.out.println("예금액:");
							int deposit= Integer.parseInt(sc.nextLine());
							ac[i].plusMoney(deposit);
							break;
					}
					
				case 4:
					System.out.println("------------\n계좌목록\n------------");
					System.out.println("계좌번호:");
					String findnum1=sc.nextLine();
					for(int i=0; i<count; i++) {
						if(ac[i].chenckno(findnum1))
							System.out.println("출금액:");
							int deposit= Integer.parseInt(sc.nextLine());
							ac[i].minusMoney(deposit);
							break;
					}
				default:
					break END;
					}//스위치
			
			
			
			
			
			
		}//와일
		
		
		
		
		
		
		
		
		
	}

}
