package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam_Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 상품명과 수량, 단가를 각각 입력받은 후 총 금액을 출력하시오
		 * 그리고 수량이 5개 이상일 경우 10프로 할인된 최종 금액도 출력해주세요
		 * 
		 * (예)
		 * 상품명 : 딸기
		 * 수량 : 6
		 * 단가 : 1000
		 * 
		 * 총금액 : 6000 원
		 * 5개 이상 10프로 할인된 금액 : 5400원
		 */
		
		//선언
		Scanner sc = new Scanner(System.in);
		NumberFormat numberFormat = NumberFormat.getInstance();
		String product;
		int count, cost, total;
		//입력
		System.out.println("상품명");
		product = sc.nextLine();
		
		System.out.println("수량");
		count = sc.nextInt();
		
		System.out.println("단가");
		cost = sc.nextInt();
		//계싼
		total = count*cost;
		
		//출력
		System.out.println("총금액 : "+numberFormat.format(total)+"원");
		
		//조건 5개 이상 10%할인
		if(cost >=5) {
			total=(int)(total*0.9); // total은 int 기 떄문에 double인 0.9랑 계산이 안됨 그래서 괄호로 따로 하고 형변환 int 선언
			System.out.printf("5개 이상 10프로 할인된 금액 %d",total);
		}
		

	}

}
