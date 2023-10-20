package test0908;


import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		arr[0]=sc.nextInt();
		int max = arr[0];
		int min = arr[0];
		for(int i=1; i<9; i++) {
			arr[i] = sc.nextInt();			
			if(min>arr[i])
				min=arr[i];
			if(max<arr[i])
				max=arr[i];			
		}
		System.out.print(max+"\n"+min);
	}

	}

/*
 * 		int amount = Integer.parseInt(sc.nextLine());
		String[] arr = new String[amount];
 */

