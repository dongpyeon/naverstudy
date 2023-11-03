import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		text = text.trim();
		String [] arr = text.split(" ");
		
		if(arr[0]=="")
			System.out.println("0");
		else
			System.out.println(arr.length);
	}	
}

