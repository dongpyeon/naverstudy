package bit701.day0901;

import java.util.Scanner;

public class Ex_2ddi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//태어난 년도를 입력받아 띠를 구해보세요
		//서기 1년이 닭띠의 해 이다
		//0000%12 == 1 이면 닭띠인것
		
		//선언
		Scanner sc=new Scanner(System.in);
		//
		System.out.println("태어난 년도는?");
		int birth =sc.nextInt();
		int m=birth%12;
		//(1년은 닭 12년이 원숭이
		String belt = m==0?"원숭이":m==1?"닭":m==2?"개":m==3?"돼지":m==4?"쥐":
					  m==5?"소":m==6?"호랑이":m==7?"토끼":m==8?"용":m==9?"뱀":
					  m==10?"말":"양";
		System.out.printf("%d 년생은 %s띠 입니다",birth,belt);
	}

}
