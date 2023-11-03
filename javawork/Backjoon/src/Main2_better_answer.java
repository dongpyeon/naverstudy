import java.util.Scanner;

public class Main2_better_answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().trim(); // 입력 문자열 앞뒤 공백 제거

        if (text.length() == 1) {
            return;
        } else {
            String[] arr = text.split(" ");
            if (arr.length < 2) {
                System.out.println("올바른 입력 형식이 아닙니다.");
                return;
            }
            int count = Integer.parseInt(arr[0]);
            for (int i = 0; i < arr[1].length(); i++) {
                char a = arr[1].charAt(i);
                for (int j = 0; j < count; j++) {
                    System.out.print(a);
                }
            }
        }
    }
}