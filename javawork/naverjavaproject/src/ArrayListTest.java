import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<String> list1 = new ArrayList<String>();
		String num;
		int count=0;
		while(true)
		{
			
			System.out.println("넣을숫자를 입력하세요");
			num = sc.nextLine();
			//
			if(num.equals("esc"))
				break;
			else if(num.equals("go"))
			{
				for(int i=0; i<list1.size(); i++) {
					System.out.println(list1.get(i));
				}
				break;
			}
			//
			count++;
			list1.add(num);
			
		}
		
	}

}
