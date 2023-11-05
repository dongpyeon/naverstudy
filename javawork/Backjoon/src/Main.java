import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int sum =0;
		int temp=0;
		for(int i =0; i<text.length(); i++)
		{
			char a = text.charAt(i);
			int b=0;

			if(a=='A' || a=='B' || a=='C')
				b=3;
			else if(a=='D' || a=='E' || a=='F')
				b=4;
			else if(a=='G' || a=='H' || a=='I')
				b=5;
			else if(a=='J' || a=='K' || a=='L')
				b=6;
			else if(a=='M' || a=='N' || a=='O')
				b=7;
			else if(a=='P' || a=='Q' || a=='R'|| a=='S' )
				b=8;
			else if(a=='T' || a=='U' || a=='V')
				b=9;
			else if(a=='W' || a=='X' || a=='Y'|| a=='Z')
				b=10;

			sum+=b;
			temp=b;
			}
			System.out.println(sum);
		}
		
	}	


