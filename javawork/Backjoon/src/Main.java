import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		if(text.length()==1){
			return;
		}
		else {
			String [] arr = text.split(" ");
			int count = Integer.parseInt(arr[0]);
			for(int i =0; i<arr[1].length(); i++) {
				char a=arr[1].charAt(i);
					for(int j=0; j<count; j++)
					{
						System.out.print(a);
					}

			}
		}
	}	
}

