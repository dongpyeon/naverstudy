import java.util.Scanner;
 
public class Main2_better_answer{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //바구니 개수
        int m = sc.nextInt(); //바구니 역순 정렬 횟수
        
        int arr[] = new int[n + 1]; // 바구니 (1~n)
       
        for(int i=1; i<=n; i++) {
            arr[i] = i;
        }
        
        for(int k=0; k<m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
 
            for(int h=i; h<=j; h++) {
                int nn = j--;
 
                int tmp = arr[h];
                arr[h] = arr[nn];
                arr[nn] = tmp;
            }
        }
        
        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
