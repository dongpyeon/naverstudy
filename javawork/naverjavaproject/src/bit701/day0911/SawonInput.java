package bit701.day0911;

import java.util.Scanner;

public class SawonInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name;
		int sudang;
		int gibon;
		int family;
		System.out.println("이름 입력");
		name=sc.nextLine();
		System.out.println("기본 입력");
		sudang=Integer.parseInt(sc.nextLine());
		System.out.println("수당 입력");
		gibon=Integer.parseInt(sc.nextLine());
		System.out.println("팸 입력");
		family=Integer.parseInt(sc.nextLine());
		System.out.println();
		Sawon sa = new Sawon(name, gibon, sudang, family);
		System.out.println("5%세금:"+sa.getNetPay());
	}

}
