import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		for(int i =1; i<=num; i++)
		{
			String text = sc.nextLine();
			System.out.println(text.substring(0, 1)+text.substring(text.length()-1, text.length()));
		}
		
	}

	}